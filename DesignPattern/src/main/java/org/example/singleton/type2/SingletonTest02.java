package org.example.singleton.type2;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/22 22:29
 */
public class SingletonTest02 {

    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1 == instance2);
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}

/**
 * 饿汉式（静态代码块）
 */
class Singleton {

    /**
     * 对象实例
     */
    private final static Singleton instance;

    /*
     * 在静态代码块中，创建对象实例
     * */
    static {
        instance = new Singleton();
    }

    /**
     * 构造器私有化，外部不能new
     */
    private Singleton() {

    }

    /**
     * 提供一个公共静态方法，返回对象实例
     *
     * @return 对象实例
     */
    public static Singleton getInstance() {
        return instance;
    }
}
