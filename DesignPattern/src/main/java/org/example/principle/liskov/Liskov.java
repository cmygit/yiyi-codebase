package org.example.principle.liskov;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/20 16:34
 */
public class Liskov {

    public static void main(String[] args) {
        A a = new A();
        System.out.println("11-3=" + a.func1(11, 3));
        System.out.println("1-8=" + a.func1(1, 8));

        System.out.println("------------------------");
        B b = new B();
        System.out.println("11-3=" + b.func1(11, 3));
        System.out.println("1-8=" + b.func1(1, 8));
        System.out.println("11+3+9=" + b.func2(11, 3));
    }
}

class A {

    public int func1(int a, int b) {
        return a - b;
    }
}

/**
 * B类继承了A类
 * 增加了一个新功能
 */
class B extends A {

    /**
     * 这里重写了A类的方法，但是在别的地方有可能不会注意到这一点
     *
     * @param a
     * @param b
     * @return
     */
    @Override
    public int func1(int a, int b) {
        return a + b;
    }

    /**
     * 这里有可能没注意到func1被重写了
     *
     * @param a
     * @param b
     * @return
     */
    public int func2(int a, int b) {
        return this.func1(a, b) + 9;
    }

}
