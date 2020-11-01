package org.example.visitor;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/1 15:22
 */
public class Client {

    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.attach(new Man());
        objectStructure.attach(new Man());
        objectStructure.attach(new Man());
        objectStructure.attach(new Woman());
        objectStructure.attach(new Woman());
        objectStructure.attach(new Woman());

        Action success = new Success();
        objectStructure.display(success);
        System.out.println("-------------------");
        Action fail = new Fail();
        objectStructure.display(fail);
        System.out.println("-------------------");
        Action wait = new Wait();
        objectStructure.display(wait);
    }
}
