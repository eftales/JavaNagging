package com.company.issues;

import com.company.Issues;

public class ExtendIssues  implements Issues {
    public void show(){
        Person p = new Person(10,"P");
        Student s = new Student(10,"S",20);
        p.introduce();
        s.introduce();
        s.getAge();
        System.out.println(s.age);

        boolean res =  s.getClass() == s.getParentClass();

        // 多态后 成员变量用父类，方法用子类
        Person sp = (Person) s;
        sp.introduce();
        System.out.println(sp.age);
        sp.getAge();


    }
}
