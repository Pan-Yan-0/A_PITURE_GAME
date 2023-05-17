package com.itheima.demo1;

import java.util.Scanner;

/********* Begin *********/

public class Triangle extends Shape {
    private int sizeA;
    private int sizeB;
    private int sizeC;

    public int getSizeA() {
        return sizeA;
    }

    public void setSizeA(int sizeA) {
        this.sizeA = sizeA;
    }

    public int getSizeB() {
        return sizeB;
    }

    public void setSizeB(int sizeB) {
        this.sizeB = sizeB;
    }

    public int getSizeC() {
        return sizeC;
    }

    public void setSizeC(int sizeC) {
        this.sizeC = sizeC;
    }

    public Triangle() {
    }

    public Triangle(int sizeA, int sizeB, int sizeC) {
        this.sizeA = sizeA;
        this.sizeB = sizeB;
        this.sizeC = sizeC;
    }

    @Override
    public double getPerimeter() {
        return sizeA+sizeB+sizeC;
    }

    @Override
    public double getArea() {
        double cosC = (double) (sizeA * sizeA + sizeB * sizeB - sizeC * sizeC) /(2*sizeA*sizeB);
        double sinC = Math.sqrt(1 - cosC*cosC);
        return sizeA*sizeB*sinC/2;
    }

    @Override
    public void input(Scanner shapeName) {
        super.shapeName = "triangle";
        System.out.println("input lengths of three sides:");
        sizeA = shapeName.nextInt();
        sizeB = shapeName.nextInt();
        sizeC = shapeName.nextInt();
    }
    /********* End *********/
}