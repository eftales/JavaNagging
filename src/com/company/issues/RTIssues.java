package com.company.issues;

import com.company.Issues;

public class RTIssues  implements Issues {
    public void show(){
        Runtime rt = Runtime.getRuntime();
        try {
            rt.exec("ipconfig");
        }
        catch (Exception e){
            System.out.println(e.getCause());
        }

    }
}
