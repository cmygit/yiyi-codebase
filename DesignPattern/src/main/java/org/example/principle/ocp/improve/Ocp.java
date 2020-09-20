package org.example.principle.ocp.improve;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/20 17:24
 */
public class Ocp {

    public static void main(String[] args) {
        GraphicEditor editor = new GraphicEditor();
        editor.drawShape(new Rectangle());
        editor.drawShape(new Circle());
        editor.drawShape(new Triangle());
        editor.drawShape(new Ellipse());
    }
}

/**
 * 绘图类
 */
class GraphicEditor {

    /**
     * 绘制不同的图案
     *
     * @param shape
     */
    public void drawShape(Shape shape) {
        shape.draw();
    }
}

abstract class Shape {

    int mType;

    public abstract void draw();
}

class Rectangle extends Shape {

    public Rectangle() {
        super.mType = 1;
    }

    @Override
    public void draw() {
        System.out.println(" 绘制矩形 ");
    }
}

class Circle extends Shape {

    public Circle() {
        super.mType = 2;
    }

    @Override
    public void draw() {
        System.out.println(" 绘制圆形 ");
    }
}

class Triangle extends Shape {

    public Triangle() {
        super.mType = 3;
    }

    @Override
    public void draw() {
        System.out.println(" 绘制三角形 ");
    }
}

class Ellipse extends Shape {

    public Ellipse() {
        this.mType = 4;
    }

    @Override
    public void draw() {
        System.out.println(" 绘制椭圆形 ");
    }
}
