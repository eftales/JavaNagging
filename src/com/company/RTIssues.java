package com.company;

public class RTIssues {
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
