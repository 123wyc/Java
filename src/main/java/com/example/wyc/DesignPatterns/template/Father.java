package com.example.wyc.DesignPatterns.template;

public  abstract class Father {


    public  final  void  process(){

        System.out.println("father class process method");

        subClassMethod();
    }


    /**
     * 由子类实现
     */
    protected abstract void subClassMethod() ;
}
