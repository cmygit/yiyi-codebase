package org.example.prototype.improve;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/25 23:56
 */
public class Sheep implements Cloneable {

    private String name;

    private int age;

    private String color;

    private String address = "蒙古";

    public Sheep(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    /**
     * 使用默认的clone方法
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone()  {
        Sheep sheep = null;

        try {
            sheep = (Sheep) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }

        return sheep;
    }
}
