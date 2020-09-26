package org.example.builder.improve;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/26 15:38
 */
public abstract class HouseBuilder {

    protected House house = new House();

    public abstract void buildBase();

    public abstract void buildWalls();

    public abstract void roofed();

    /**
     * 建造房子
     *
     * @return
     */
    public House buildHouse() {
        return this.house;
    }
}
