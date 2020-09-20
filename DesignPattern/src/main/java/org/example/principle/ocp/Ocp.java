package org.example.principle.ocp;

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
        if (shape.mType == 1) {
            this.drawRectangle(shape);
        } else if (shape.mType == 2) {
            this.drawCircle(shape);
        } else if (shape.mType == 3) {
            this.drawTriangle(shape);
        }
    }

    private void drawRectangle(Shape shape) {
        System.out.println(" 绘制矩形 ");
    }

    private void drawCircle(Shape shape) {
        System.out.println(" 绘制圆形 ");
    }

    private void drawTriangle(Shape shape) {
        System.out.println(" 绘制三角形 ");
    }
}

class Shape {

    int mType;
}

class Rectangle extends Shape {

    public Rectangle() {
        super.mType = 1;
    }
}

class Circle extends Shape {

    public Circle() {
        super.mType = 2;
    }
}

class Triangle extends Shape {

    public Triangle() {
        super.mType = 3;
    }
}
