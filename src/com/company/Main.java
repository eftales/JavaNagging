package com.company;


import com.company.issues.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        List<Class<?>> classes =  new ClassScanner("com.company.issues").getClasses(); // 扫描路径下所有的 class 文件
        for (Class clz:classes) {
            System.out.print(clz); // 通过 AOP 的方式进行展示，其实不用 AOP 也能实现一样的效果（
            Issues issues = (Issues) Proxy.newProxyInstance(clz.getClassLoader(),new Class[]{Issues.class},new AOPHandler(clz.newInstance()));
            issues.show();
        }

    }


}

