package com.company;


public class Main {

    public static void main(String[] args) {

        new StringIssues().show();
        new ShortIssues().show();
        new ArrayIssues().show();
        new ExtendIssues().show();
        new WrapperIssues().show();

        new RTIssues().show();

        new CollectionIssues().show();

        StringIssues si = new StringIssues();
        si.getClass();

        Object obj = new Object();
        obj.getClass();
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
        boolean res1 = str2==str1; // str2!=str1

        String str3 = "h"+"e"+"l"+"l"+"o"; // 编译器就已经确定好了
        boolean res2 = str3==str1; // str2==str3

        String str4 = "helloworld";
        String str5 = str1+"world";
        boolean res3 = str4==str5; // str4!=str5
        res3 = str4.equals(str5);
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

class ExtendIssues{
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


class WrapperIssues{
    public void show(){
        // 包装类是引用类型，因此不能直接用 == 比较值是否相等，-128~127除外
        // 这里用了 new 新建了变量，所以两个的引用值不等
        Integer itr1 = new Integer(2);
        Integer itr2 = new Integer(2);
        boolean bl1 = itr1 == itr2;

        // 这里用了自动装箱的机制，所以两个的引用值相等
        Integer itr12 = 2;
        Integer itr22 = 2;
        boolean bl2 = itr12 == itr12;

        // 获得缓存的包装类的另一种写法
        Integer itr2v1 = Integer.valueOf(2);
        Integer itr2v2 = Integer.valueOf(2);
        bl2 = itr2v1 == itr2v2;

        // 大于 127 就不会自动装箱了，本质上还是 new 出来的
        Integer itr13 = 200;
        Integer itr23 = 200;
        boolean bl3 = itr13 == itr23;
        boolean bl4 = itr13.equals(itr23);

    }
}
