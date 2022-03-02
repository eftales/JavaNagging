package com.company;

public class Person {

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int age;
    public String name;

    public Person introduce(){
        System.out.println("I am a person, named "+name);
        return this;
    }

    public int getAge(){
        System.out.printf("I am %d years old.\n",age );
        return age;
    }

}

class Student extends Person{

    public Student(int age, String name, int score) {
        super(age,name); // super 必须在第一行

        this.score = score;
        this.age = age + 1;

    }

    public int age;
    public int score;


    public Student introduce(){
        // 重写方法的返回值如果是基本类型 必须返回一样的类型
        // 重写方法的返回值如果是引用类型 必须本类或子类
        System.out.println("I am a student, named "+name);
        return this;
    }

}
