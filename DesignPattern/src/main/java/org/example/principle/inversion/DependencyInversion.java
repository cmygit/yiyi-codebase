package org.example.principle.inversion;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/19 15:42
 */
public class DependencyInversion {

    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
    }
}

class Email {

    public String getInfo() {
        return "Email Info: Hello, world.";
    }
}

/**
 * 方式1分析
 * 1、简单，比较容易实现
 * 2、如果我们需要获取的对象是其他的类，则Person也要增加相应的方法
 * 3、解决思路：引入一个抽象的接口IReceiver，表示接受者，这样Person类与接口IReceiver发生依赖
 *  要获取的对象只需各自实现IReceiver接口即可。
 */
class Person {

    public void receive(Email email) {
        System.out.println(email.getInfo());
    }
}
