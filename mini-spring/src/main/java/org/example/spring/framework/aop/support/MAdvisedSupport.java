package org.example.spring.framework.aop.support;

import lombok.Data;
import org.example.spring.framework.aop.aspect.MAdvice;
import org.example.spring.framework.aop.config.MAopConfig;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/6 20:17
 */
@Data
public class MAdvisedSupport {

    private Class<?> targetClass;

    private Object target;

    private MAopConfig config;

    private Pattern pointCutClassPattern;

    private Map<Method, Map<String, MAdvice>> methodCache;

    public MAdvisedSupport(MAopConfig config) {
        this.config = config;
    }

    public void setTargetClass(Class<?> targetClass) {
        this.targetClass = targetClass;
        this.parse();
    }

    private void parse() {
        // 切面表达式
        String pointCut = this.config.getPointCut();
        // public .* org.example.demo.service..*Service.*..*(.*)
        // 用于匹配方法的字符串
        Pattern pointCutPattern = Pattern.compile(pointCut);

        // public .* org.example.demo.service..*Service.*..*(.*) -> public .* org.example.demo.service..*Service.*
        String pointCutForClassRegex = pointCut.substring(0, pointCut.lastIndexOf("(") - 3);
        // public .* org.example.demo.service..*Service.* -> org.example.demo.service..*Service.*
        pointCutForClassRegex = pointCutForClassRegex.substring(pointCutForClassRegex.lastIndexOf(" ") + 1);

        // class org.example.demo.service..*Service.*
        // 用于匹配class的字符串，this.targetClass.toString()
        this.pointCutClassPattern = Pattern.compile("class " + pointCutForClassRegex);

        methodCache = new HashMap<>();

        // 1、把切面类的所有回调方法先缓存起来
        Map<String, Method> aspectMethods = new HashMap<>();
        try {
            Class<?> aspectClass = Class.forName(this.config.getAspectClass());
            for (Method method : aspectClass.getDeclaredMethods()) {
                aspectMethods.put(method.getName(), method);
            }

            // 2、扫描目标类中的所有方法
            for (Method method : this.targetClass.getDeclaredMethods()) {
                // 如 public java.lang.String org.example.Test.hello(java.lang.String name) throws java.lang.Exception
                String methodStr = method.toString();
                if (methodStr.contains("throws")) {
                    // public java.lang.String org.example.Test.hello(java.lang.String name) throws Exception
                    // -> public java.lang.String org.example.Test.hello(java.lang.String name)
                    methodStr = methodStr.substring(0, methodStr.lastIndexOf("throws")).trim();
                }

                // 切面表达式正则匹配目标类的方法的字符串，若匹配，则需要对该方法进行切面
                Matcher matcher = pointCutPattern.matcher(methodStr);
                // Matcher matcher = this.pointCutClassPattern.matcher(methodStr);
                if (!matcher.matches()) {
                    continue;
                }

                // 保存该方法所需的advice信息
                Map<String, MAdvice> advices = new HashMap<>();

                String aspectBefore = this.config.getAspectBefore();
                if (aspectBefore != null && !"".equals(aspectBefore)) {
                    MAdvice advice = new MAdvice(aspectClass.newInstance(), aspectMethods.get(aspectBefore));
                    advices.put(aspectBefore, advice);
                }

                String aspectAfter = this.config.getAspectAfter();
                if (aspectBefore != null && !"".equals(aspectAfter)) {
                    MAdvice advice = new MAdvice(aspectClass.newInstance(), aspectMethods.get(aspectAfter));
                    advices.put(aspectAfter, advice);
                }

                String aspectAfterThrow = this.config.getAspectAfterThrow();
                if (aspectBefore != null && !"".equals(aspectAfterThrow)) {
                    MAdvice advice = new MAdvice(aspectClass.newInstance(), aspectMethods.get(aspectAfterThrow));
                    advice.setThrowName(this.config.getAspectAfterThrowingName());
                    advices.put(aspectAfterThrow, advice);
                }

                // 保存所有需要切面方法对应的advice
                this.methodCache.put(method, advices);
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    public boolean pointCutMatch() {
        return pointCutClassPattern.matcher(this.targetClass.toString())
                                   .matches();
    }

    public Map<String, MAdvice> getAdvices(Method method, Class<?> targetClass) throws NoSuchMethodException {
        Map<String, MAdvice> advices = this.methodCache.get(method);

        // 若传进来的方法是代理类的方法，则获取的advices会为空，这时候需要借助目标类获取原始的方法反射信息
        if (advices == null) {
            Method originMethod = targetClass.getMethod(method.getName(), method.getParameterTypes());
            // 拿到原始的方法反射信息，再获取一次advices
            advices = this.methodCache.get(originMethod);
            // 同时把获取到的advices，重新以代理类的方法为key保存起来，以便下次获取的时候不需要再判断
            this.methodCache.put(method, advices);
        }

        return advices;
    }
}
