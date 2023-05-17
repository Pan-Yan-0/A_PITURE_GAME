package com.itheima.demo1;

import java.util.Scanner;

public abstract class Shape {
    public String shapeName;
    public abstract double getPerimeter();

    public abstract double getArea();
    public abstract   void input(Scanner shapeName);
}
