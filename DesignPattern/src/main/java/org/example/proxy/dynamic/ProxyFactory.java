package org.example.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/10/4 15:57
 */
public class ProxyFactory {

    /**
     * 维护一个目标对象
     */
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 获取代理对象
     *
     * @return
     */
    public Object getProxyInstance() {
        // 目标类的类加载器
        ClassLoader classLoader = this.target.getClass().getClassLoader();
        // 目标类实现的接口
        Class<?>[] interfaces = this.target.getClass().getInterfaces();
        // 调用目标类的方法时的处理器
        InvocationHandler handler = (proxy, method, args) -> {
            System.out.println(" JDK动态代理 开始 ");
            Object returnVal = method.invoke(target, args);
            System.out.println(" JDK动态代理 结束 ");
            return returnVal;
        };

        // 返回代理对象
        return Proxy.newProxyInstance(classLoader, interfaces, handler);
    }
}
