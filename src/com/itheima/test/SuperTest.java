package com.itheima.test;

public class SuperTest {
    public static void main(String[] args) {
        // 实例化一个Student类的对象s，为Student对象s中的school赋值，打印输出信息
        /********* begin *********/
        Student s = new Student("张三",18);
        System.out.println("姓名："+s.getName()+"，年龄："+s.getAge()+"，学校："+Student.school);
        /********* end *********/
    }
}

class Person {
    /********* begin *********/
    private String name;
    private int age;

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

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    /********* end *********/
}

class Student extends Person {
    /********* begin *********/
    public Student() {
    }

    public Student(String name, int age) {
        super(name, age);
    }
    public static String school = "哈佛大学";
    /********* end *********/
}