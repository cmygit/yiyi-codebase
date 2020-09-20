package org.example.principle.liskov.improve;

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
        System.out.println("11+3=" + b.func1(11, 3));
        System.out.println("1+8=" + b.func1(1, 8));
        System.out.println("11+3+9=" + b.func2(11, 3));
        System.out.println("11-3=" + b.func3(11, 3));
    }
}

class Base {

}

class A extends Base {

    public int func1(int a, int b) {
        return a - b;
    }
}

/**
 * B类继承了A类
 * 增加了一个新功能
 */
class B extends Base {

    /**
     * 如果B类需要使用A类的方法，使用组合关系
     */
    private A a = new A();

    /**
     * @param a
     * @param b
     * @return
     */
    public int func1(int a, int b) {
        return a + b;
    }

    /**
     * @param a
     * @param b
     * @return
     */
    public int func2(int a, int b) {
        return this.func1(a, b) + 9;
    }

    public int func3(int num1, int num2) {
        return this.a.func1(num1, num2);
    }
}
