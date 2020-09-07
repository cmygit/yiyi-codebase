package org.example.spring.framework.aop;

import org.example.spring.framework.aop.aspect.MAdvice;
import org.example.spring.framework.aop.support.MAdvisedSupport;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/6 20:17
 */
public class MJDKDynamicAopProxy implements InvocationHandler {

    private final MAdvisedSupport config;

    public MJDKDynamicAopProxy(MAdvisedSupport config) {
        this.config = config;
    }

    public Object getProxy() {
        ClassLoader loader = this.getClass()
                                 .getClassLoader();

        Class<?>[] interfaces = this.config.getTargetClass()
                                           .getInterfaces();

        return Proxy.newProxyInstance(loader, interfaces, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Map<String, MAdvice> advices = this.config.getAdvices(method, this.config.getTargetClass());

        String aspectBefore = this.config.getConfig().getAspectBefore();
        this.invokeAdvice(advices.get(aspectBefore));

        Object returnValue = null;
        try {
            returnValue = method.invoke(this.config.getTarget(), args);
        } catch (Exception e) {
            String aspectAfterThrow = this.config.getConfig().getAspectAfterThrow();
            this.invokeAdvice(advices.get(aspectAfterThrow));
        }

        String aspectAfter = this.config.getConfig().getAspectAfter();
        this.invokeAdvice(advices.get(aspectAfter));

        return returnValue;
    }

    private void invokeAdvice(MAdvice advice) throws InvocationTargetException, IllegalAccessException {
        advice.getAdviceMethod()
              .invoke(advice.getAspect());
    }
}
