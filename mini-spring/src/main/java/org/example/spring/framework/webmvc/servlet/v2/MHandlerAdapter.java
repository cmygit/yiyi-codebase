package org.example.spring.framework.webmvc.servlet.v2;

import org.example.spring.framework.annotation.MRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/8/29 15:55
 */
public class MHandlerAdapter {

    public MModelAndView handle(HttpServletRequest req, HttpServletResponse resp, MHandlerMapping handlerMapping) throws InvocationTargetException, IllegalAccessException {
        // 1、保存带有@MRequestParam注解的参数名及其顺序
        Map<String, Integer> paramIndexMapping = new HashMap<>();
        Method method = handlerMapping.getMethod();
        Annotation[][] pas = method.getParameterAnnotations();

        for (int i = 0; i < pas.length; i++) {
            for (Annotation a : pas[i]) {
                if (!(a instanceof MRequestParam)) {
                    continue;
                }

                String paramName = ((MRequestParam) a).value();
                if ("".equals(paramName.trim())) {
                    continue;
                }

                paramIndexMapping.put(paramName, i);
            }
        }

        // 2、保存HttpServletRequest和HttpServletResponse的参数类型名及其顺序
        Class<?>[] parameterTypes = method.getParameterTypes();

        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> parameterType = parameterTypes[i];
            if (parameterType != HttpServletRequest.class && parameterType != HttpServletResponse.class) {
                continue;
            }
            paramIndexMapping.put(parameterType.getName(), i);
        }

        // 3、给方法参数赋值
        // 请求参数
        Map<String, String[]> reqParams = req.getParameterMap();
        // 存放方法参数值
        Object[] methodParamValues = new Object[parameterTypes.length];

        // 对带有@MRequestParam注解的参数赋值
        for (Map.Entry<String, String[]> reqParam : reqParams.entrySet()) {
            String reqParamName = reqParam.getKey();
            if (!paramIndexMapping.containsKey(reqParamName)) {
                continue;
            }

            // 请求参数值
            String reqParamValue = Arrays.toString(reqParam.getValue())
                                         .replaceAll("[\\[\\]]", "")
                                         .replaceAll("\\s+", "");

            Integer index = paramIndexMapping.get(reqParamName);
            // 将请求参数值转换为String，并赋值给方法参数
            methodParamValues[index] = this.castStringValue(reqParamValue, parameterTypes[index]);
        }



        // 对HttpServletRequest和HttpServletResponse赋值
        String className = HttpServletRequest.class.getName();
        if (paramIndexMapping.containsKey(className)) {
            Integer index = paramIndexMapping.get(className);
            methodParamValues[index] = req;
        }

        className = HttpServletResponse.class.getName();
        if (paramIndexMapping.containsKey(className)) {
            Integer index = paramIndexMapping.get(className);
            methodParamValues[index] = resp;
        }

        // 4、调用方法
        Object result = method.invoke(handlerMapping.getController(), methodParamValues);

        if (result == null || result instanceof Void) {
            return null;
        }

        if (method.getReturnType() == MModelAndView.class) {
            return (MModelAndView) result;
        }

        return null;
    }

    private Object castStringValue(String value, Class<?> type) {
        if (String.class == type) {
            return value;
        } else if (Integer.class == type) {
            return Integer.valueOf(value);
        } else if (Double.class == type) {
            return Double.valueOf(value);
        }

        if (value != null) {
            return value;
        }

        return null;
    }
}
