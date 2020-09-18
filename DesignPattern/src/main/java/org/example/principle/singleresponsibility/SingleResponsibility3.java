package org.example.principle.singleresponsibility;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/18 20:50
 */
public class SingleResponsibility3 {

    public static void main(String[] args) {
        Vehicle2 vehicle = new Vehicle2();
        vehicle.runRoad("car");
        vehicle.runAir("airplane");
        vehicle.runWater("ship");

    }
}

/**
 * 方案3的分析
 * 1、这种修改方法没有对原来的类做大的修改，只是增加方法
 * 2、这里虽然没有在类的级别上遵守单一职责原则，但是在方法的级别上，仍遵守单一职责原则
 */
class Vehicle2 {

    public void runRoad(String vehicle) {
        System.out.println(vehicle + " 在公路运行......");
    }

    public void runAir(String vehicle) {
        System.out.println(vehicle + " 在天上运行......");
    }

    public void runWater(String vehicle) {
        System.out.println(vehicle + " 在水中运行......");
    }
}
