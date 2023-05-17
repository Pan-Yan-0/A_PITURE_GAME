package com.itheima.test;

public class TestPolymorphism {
    public static void main(String[] args) {
        // 以多态方式分别实例化子类对象并调用eat()方法
        /********* begin *********/
        Animal dog = new Dog();
        dog.eat();
        Animal cat = new Cat();
        cat.eat();
        Animal lion = new Lion();
        lion.eat();
        /********* end *********/
    }
}

// Animal类中定义eat()方法
class Animal {
    /********* begin *********/
    public void eat(){
        System.out.println();
    }
    /********* end *********/
}

// Dog类继承Animal类 复写eat()方法
class Dog extends Animal {
    /********* begin *********/
    @Override
    public void eat() {
        System.out.println("eating bread...");
    }
    /********* end *********/
}

// Cat类继承Animal类 复写eat()方法
class Cat extends Animal {
    /********* begin *********/
    @Override
    public void eat() {
        System.out.println("eating rat...");
    }
    /********* end *********/
}

// Lion类继承Animal类 复写eat()方法
class Lion extends Animal {
    /********* begin *********/
    @Override
    public void eat() {
        System.out.println("eating meat...");
    }
    /********* end *********/
}