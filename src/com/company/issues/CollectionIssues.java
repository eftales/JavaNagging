package com.company.issues;

import com.company.Issues;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionIssues  implements Issues {
    public void show(){
        List<String> li = new ArrayList<>();
        for(int i=0;i<10;++i){
            li.add(String.valueOf(i));
        }

        String in = li.get(0);
        li.clear(); // clear 只是释放 li 里面的指针，并不释放内存，比如说 in 在 clear 后还是有效的

        // 迭代器
        for(int i=0;i<10;++i){
            li.add(String.valueOf(i));
        }
        Iterator it = li.iterator();
        while(it.hasNext()){
            String c = (String) it.next();
            it.remove();

        }


        // 类型擦除
        List<String>[] lss = new ArrayList[10];

        Ttest ttest = new Ttest<String>(10);
        List<String>[] data = ttest.createArray(10);

    }
}

class Ttest <T>{
    private List<T>[] data;
    public Ttest(int size){
        data = new ArrayList[size];
    }

    public List<T>[] createArray(int size){
        return new ArrayList[size];
    }

//    public <S> S createInstance(){
//        return new S(); // 不知道 S 的类型，所以也不知道 S 构造器的签名，所以没办法调用
//    }
}


