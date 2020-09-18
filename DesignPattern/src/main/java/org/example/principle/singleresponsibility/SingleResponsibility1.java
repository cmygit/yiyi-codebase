package org.example.principle.singleresponsibility;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/18 20:26
 */
public class SingleResponsibility1 {

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("motorcycle");
        vehicle.run("car");
        vehicle.run("airplane");
    }
}

/**
 * 交通工具类
 * 方式1
 * 1、在方式1的run方法中，违反了单一职责原则
 * 2、解决方法：根据交通工具运行方式的不同，分解成不同类即可
 */
class Vehicle {

    public void run(String vehicle) {
        System.out.println(vehicle + " 在公路运行......");
    }
}
