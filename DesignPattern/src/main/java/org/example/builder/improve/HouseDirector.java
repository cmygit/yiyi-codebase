package org.example.builder.improve;

/**
 * @Title: 指挥者 指定制作流程，返回结果
 * @Author: cmy
 * @Date: 2020/9/26 15:44
 */
public class HouseDirector {

    HouseBuilder builder = null;

    public HouseDirector(HouseBuilder builder) {
        this.builder = builder;
    }

    public void setBuilder(HouseBuilder builder) {
        this.builder = builder;
    }

    public House constructHouse() {
        this.builder.buildBase();
        this.builder.buildWalls();
        this.builder.roofed();

        return this.builder.buildHouse();
    }
}
