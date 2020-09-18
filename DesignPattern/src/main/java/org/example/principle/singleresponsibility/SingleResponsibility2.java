package org.example.principle.singleresponsibility;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/18 20:42
 */
public class SingleResponsibility2 {

    public static void main(String[] args) {
        RoadVehicle roadVehicle = new RoadVehicle();
        roadVehicle.run("motorcycle");
        roadVehicle.run("car");

        AirVehicle airVehicle = new AirVehicle();
        airVehicle.run("airplane");

        WaterVehicle waterVehicle = new WaterVehicle();
        waterVehicle.run("ship");
    }
}

/**
 * 方案2的分析
 * 1、遵守单一职责原则
 * 2、但是这样做的改动很大，即将类分解，同时修改客户端
 * 3、改进：直接修改Vehicle类，改动的代码会比较少=>方案3
 */
class RoadVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + " 在公路运行......");
    }
}

class AirVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + " 在天上运行......");
    }
}

class WaterVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + " 在水中运行......");
    }
}
