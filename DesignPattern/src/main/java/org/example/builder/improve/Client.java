package org.example.builder.improve;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/26 15:46
 */
public class Client {

    public static void main(String[] args) {
        HouseDirector director = new HouseDirector(new CommonHouse());
        director.constructHouse();

        director.setBuilder(new HighBuilding());
        director.constructHouse();
    }
}
