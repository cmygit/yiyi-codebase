package org.example.builder.improve;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/26 15:42
 */
public class HighBuilding extends HouseBuilder {

    @Override
    public void buildBase() {
        System.out.println(" 高楼打地基100米 ");
    }

    @Override
    public void buildWalls() {
        System.out.println(" 高楼砌墙20cm ");
    }

    @Override
    public void roofed() {
        System.out.println(" 高楼封顶 ");
    }
}
