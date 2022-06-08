package com.company.issues;

import java.util.Arrays;


public class Zoo implements Cloneable{
    int id;
    public Animal[] animals;


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // 浅克隆
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "id=" + id +
                ", animals=" + Arrays.toString(animals) +
                '}';
    }

    public Zoo(int id, int num){
        this.id = id;
        animals = new Animal[num];
        for(int i=0;i<num;++i){
            if(i%2==0){
                animals[i] = new Dog(i);
            }
            else{
                animals[i] = new Cat(i);
            }
        }
    }

}

abstract class Animal{
    String name;

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Dog extends Animal{
    public Dog(int id){
        this.name = "Dog"+id;
    }
}

class Cat extends Animal{
    public Cat(int id){
        this.name = "Cat"+id;
    }
}