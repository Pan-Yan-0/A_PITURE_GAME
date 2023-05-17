package com.itheima.demo1;

import java.util.Scanner;

/********* Begin *********/

public class Rectangle extends Shape {

    private double width;
    public Rectangle(){

    }
    public double getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    private double height;

    public Rectangle(int width, int height) {
        this.width = width;

        this.height = height;
    }

    @Override
    public double getPerimeter() {
        return (width + height) * 2;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public void input(Scanner shapeName) {
        super.shapeName = "rectangle";
        System.out.println("input width and height:");
        width = shapeName.nextDouble();
        height = shapeName.nextDouble();
    }

    /********* End *********/
}