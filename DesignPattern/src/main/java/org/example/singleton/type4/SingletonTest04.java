package org.example.singleton.type4;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/22 22:29
 */
public class SingletonTest04 {

    public static void main(String[] args) {
        System.out.println("懒汉式2，线程安全");
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1 == instance2);
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}

/**
 * 懒汉式（线程安全，同步方法）
 */
class Singleton {

    /**
     * 本类内部创建对象实例
     */
    private static Singleton instance;

    /**
     * 构造器私有化，外部不能new
     */
    private Singleton() {
    }

    /**
     * 提供一个公共静态方法，当使用到该方法时，才去创建 instance
     *
     * @return 对象实例
     */
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
