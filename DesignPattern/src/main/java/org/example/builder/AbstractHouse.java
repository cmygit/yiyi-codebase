package org.example.builder;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/26 12:47
 */
public abstract class AbstractHouse {

    /**
     * 打地基
     */
    public abstract void buildBasic();

    /**
     * 砌墙
     */
    public abstract void buildWalls();

    /**
     * 封顶
     */
    public abstract void roofed();

    /**
     * 建造
     */
    public void build() {
        this.buildBasic();
        this.buildWalls();
        this.roofed();
    }
}
