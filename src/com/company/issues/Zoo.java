package com.company.issues;

import java.util.Arrays;


public class Zoo implements Cloneable{
    int id;
    public Animal[] animals;


    @Override
    protected Object clone() throws CloneNotSupportedException {
//        return super.clone(); // 浅克隆


        // 以下是深克隆
        Zoo zoo = null;
        try{
            zoo = (Zoo)super.clone(); // 不能是 this.clone() !!
        }catch (CloneNotSupportedException e){
            zoo = new Zoo(this.id,this.animals.length);
        }

        zoo.animals = Arrays.copyOf(this.animals,this.animals.length); // 方法1：手动复制
//        zoo.animals = this.animals.clone(); // 方法2：调用 数组的 clone 方法

        return zoo;
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