package org.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/6 21:41
 */
public class AnimalInvocationHandler implements InvocationHandler {

    private final Animal animal;

    public AnimalInvocationHandler(Animal animal) {
        this.animal = animal;
    }

    public Object getProxyInstance() {
        ClassLoader loader = this.getClass()
                                 .getClassLoader();

        Class<?>[] interfaces = this.animal.getClass()
                                           .getInterfaces();

        return Proxy.newProxyInstance(loader, interfaces, this);
    }

    private void before() {
        System.out.println("---before---");
    }

    private void after() {
        System.out.println("---after---");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.before();

        Object invoke = method.invoke(this.animal, args);

        this.after();
        return invoke;
    }

    public Object myInvoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.before();

        Object invoke = method.invoke(this.animal, args);

        this.after();
        return invoke;
    }
}
