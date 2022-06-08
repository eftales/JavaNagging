package com.company.issues;

import com.company.Issues;

public class StringIssues implements Issues {
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
