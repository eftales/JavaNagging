package com.company;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AOPHandler implements InvocationHandler {
    Object obj ;
    public AOPHandler(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("================");
        return method.invoke(obj,args);
    }
}
