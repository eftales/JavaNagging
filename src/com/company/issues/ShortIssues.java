package com.company.issues;

import com.company.Issues;

public class ShortIssues  implements Issues {

    public void show(){
        //- 低于 int 的类型在做数值计算的时候会升格到 int
        short st1=1,st2=2;
        short st3 = (short) (st1 + st2); // ...
        st3 += 1;
    }
}
