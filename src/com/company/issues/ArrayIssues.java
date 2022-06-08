package com.company.issues;

import com.company.Issues;

public class ArrayIssues implements Issues {
    public void show(){
        Person[] persons = new Person[2]; // 创建了两个指针的位置，每个位置都存放 null 指针
        persons = new Person[]{new Person(1,"1"),new Person(2,"2")}; // 创建了两个指针的位置，每个位置都指向一个 Person 实例

        // 多维数组
        int[][] a = new int[2][];
        for(int i=0;i<a.length;++i){
            System.out.println(a[i]);
        }
        a[0] = new int[2]; // 创建了两个int大小的位置。每个位置存放int的默认值 0
        a[0][1] = 2;

        // 二维数组的每一列可以不定长
        int[][] a2d2 = new int[3][];
        a2d2[0] = new int[3];
        a2d2[1] = new int[4];
    }
}
