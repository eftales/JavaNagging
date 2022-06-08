package com.company.issues;

import com.company.Issues;

public class CloneIssues implements Issues {
    @Override
    public void show() throws CloneNotSupportedException {
        Zoo zoo1 = new Zoo(1,10);
        Zoo zoo2 = (Zoo) zoo1.clone();

        System.out.println(zoo1);
        System.out.println(zoo2);

        zoo1.id = 3;
        System.out.println(zoo1);
        System.out.println(zoo2);

        zoo1.animals[0] = new Cat(100); // 如果是浅克隆，zoo1和zoo2的列表中的类会同步修改
        System.out.println(zoo1);
        System.out.println(zoo2);
    }
}
