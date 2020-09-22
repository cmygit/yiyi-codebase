package org.example.singleton.type7;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/22 23:10
 */
public class SingletonTest07 {

    public static void main(String[] args) {
        System.out.println("使用静态内部类完成单例模式");
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1 == instance2);
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}

/**
 * 单例模式（静态内部类）
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
    public static Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }

    /**
     * 静态内部类，持有单例对象实例
     * 静态内部类在被访问到时才会被加载器加载，从而实现延迟加载和线程安全
     */
    private static class SingletonInstance {
        private static final Singleton INSTANCE = new Singleton();
    }
}
