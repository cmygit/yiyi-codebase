package org.example.singleton.type8;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/22 23:19
 */
public class SingletonTest08 {

    public static void main(String[] args) {
        Singleton instance1 = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;

        System.out.println(instance1 == instance2);
        System.out.println("instance1.hashCode() = " + instance1.hashCode());
        System.out.println("instance2.hashCode() = " + instance2.hashCode());

        instance1.hello();
        instance2.hello();
    }
}

/**
 * 单例（枚举）
 *
 * 枚举类可以防止反射以及反序列化对单例的破坏，并且实现更简洁
 */
enum Singleton {

    INSTANCE;

    public void hello() {
        System.out.println("hello~");
    }
}

