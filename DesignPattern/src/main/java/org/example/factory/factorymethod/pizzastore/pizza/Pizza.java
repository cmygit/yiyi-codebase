package org.example.factory.factorymethod.pizzastore.pizza;

/**
 * @Title: 将 Pizza 类做成抽象类
 * @Author: cmy
 * @Date: 2020/9/23 20:30
 */
public abstract class Pizza {

    /**
     * 名字
     */
    protected String name;

    /**
     * 准备原材料
     * 不同的披萨原材料不一样，因此将此方法写成抽象方法
     */
    public abstract void prepare();

    /**
     * 烤
     */
    public void bake() {
        System.out.println(this.name + " baking...");
    }

    /**
     * 切
     */
    public void cut() {
        System.out.println(this.name + " cutting...");
    }

    /**
     * 打包
     */
    public void box() {
        System.out.println(this.name + " boxing...");
    }

    public void setName(String name) {
        this.name = name;
    }
}
