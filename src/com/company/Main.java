package com.company;


public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("hello");
        new StringIssues().show();
        new ShortIssues().show();
        new ArrayIssues().show();

        Person p = new Person(10,"P");
        Student s = new Student(10,"S",20);
        p.introduce();
        s.introduce();
        s.getAge();
    }

}

class StringIssues{
    public void show(){
        //- 临时拼接的字符串也会在常量池中嘛
        String str1 = "hello";
        char[] ca = {'h','e','l','l','o'};
        String str2 = "";
        for(char c:ca){
            str2+=c;
        }
        int tmp = str2==str1?1:2; // str2!=str1

    }
}


class ShortIssues{
    public void show(){
        //- 低于 int 的类型在做数值计算的时候会升格到 int
        short st1=1,st2=2;
        short st3 = (short) (st1 + st2); // ...
        st3 += 1;
    }
}

class ArrayIssues{
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

