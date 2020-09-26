package org.example.builder.improve;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/26 15:41
 */
public class CommonHouse extends HouseBuilder {

    @Override
    public void buildBase() {
        System.out.println(" 普通房子打地基5米 ");
    }

    @Override
    public void buildWalls() {
        System.out.println(" 普通房子砌墙10cm ");
    }

    @Override
    public void roofed() {
        System.out.println(" 普通房子封顶 ");
    }
}
