package org.example.principle.inversion.improve;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/19 15:42
 */
public class DependencyInversion {

    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
        person.receive(new WeChat());
    }
}

interface IReceiver {
    String getInfo();
}

class Email implements IReceiver {

    @Override
    public String getInfo() {
        return "Email Info: Hello, world.";
    }
}

class WeChat implements IReceiver {

    @Override
    public String getInfo() {
        return "WeChat Info: Hello, ok.";
    }
}

/**
 * 方式2分析
 */
class Person {

    public void receive(IReceiver receiver) {
        System.out.println(receiver.getInfo());
    }
}
