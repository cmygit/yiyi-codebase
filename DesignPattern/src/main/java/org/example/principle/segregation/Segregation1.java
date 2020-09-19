package org.example.principle.segregation;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/19 11:43
 */
public class Segregation1 {

    public static void main(String[] args) {

    }
}

interface Interface1 {

    void operation1();

    void operation2();

    void operation3();

    void operation4();

    void operation5();
}

class B implements Interface1 {

    @Override
    public void operation1() {
        System.out.println("B implements operation1");
    }

    @Override
    public void operation2() {
        System.out.println("B implements operation2");
    }

    @Override
    public void operation3() {
        System.out.println("B implements operation3");
    }

    @Override
    public void operation4() {
        System.out.println("B implements operation4");
    }

    @Override
    public void operation5() {
        System.out.println("B implements operation5");
    }
}

class D implements Interface1 {

    @Override
    public void operation1() {
        System.out.println("D implements operation1");
    }

    @Override
    public void operation2() {
        System.out.println("D implements operation2");
    }

    @Override
    public void operation3() {
        System.out.println("D implements operation3");
    }

    @Override
    public void operation4() {
        System.out.println("D implements operation4");
    }

    @Override
    public void operation5() {
        System.out.println("D implements operation5");
    }
}

/**
 * A类通过接口Interface1依赖（使用）B类，但是只会用到1，2，3方法
 */
class A {

    public void depend1(Interface1 i) {
        i.operation1();
    }

    public void depend2(Interface1 i) {
        i.operation2();
    }

    public void depend3(Interface1 i) {
        i.operation3();
    }
}

/**
 * A类通过接口Interface1依赖（使用）D类，但是只会用到1，4，5方法
 */
class C {

    public void depend1(Interface1 i) {
        i.operation1();
    }

    public void depend4(Interface1 i) {
        i.operation4();
    }

    public void depend5(Interface1 i) {
        i.operation5();
    }
}
