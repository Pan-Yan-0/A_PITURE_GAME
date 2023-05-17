package com.itheima.demo1;

import java.util.Scanner;

public class Circle extends Shape {
    private int radius;

    public Circle() {
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void input(Scanner shapeName) {
        super.shapeName = "circle";
        System.out.println("");
        radius = shapeName.nextInt();
    }
}
