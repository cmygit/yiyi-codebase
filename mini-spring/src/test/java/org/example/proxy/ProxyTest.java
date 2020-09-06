package org.example.proxy;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/6 21:40
 */
public class ProxyTest {

    public static void main(String[] args) throws Throwable {
        Animal cat = new Cat();
        AnimalInvocationHandler invocationHandler = new AnimalInvocationHandler(cat);
        Animal animal = (Animal) invocationHandler.getProxyInstance();
        // 1
        animal.say();
        animal.run();
        System.out.println("\n等价于\n");
        // 2
        invocationHandler.myInvoke(animal, Animal.class.getMethod("say"), null);
        invocationHandler.myInvoke(animal, Animal.class.getMethod("run"), null);

        System.out.println("end...");
    }
}
