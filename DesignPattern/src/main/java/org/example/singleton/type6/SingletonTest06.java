package org.example.singleton.type6;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/22 22:29
 */
public class SingletonTest06 {

    public static void main(String[] args) {
        System.out.println("双重检查");
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1 == instance2);
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}

/**
 * 懒汉式（线程安全，双重检查）
 */
class Singleton {

    /**
     * 本类内部创建对象实例
     */
    private static volatile Singleton instance;

    /**
     * 构造器私有化，外部不能new
     */
    private Singleton() {
    }

    /**
     * 提供一个公共静态方法，当使用到该方法时，才去创建 instance
     * 加入双重检查代码，解决线程安全问题和懒加载问题，并保证了效率，推荐使用。
     *
     * @return 对象实例
     */
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }
}
