package com.example.wyc.DesignPatterns.Factory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wyc
 * @date 2020/6/1/13:10
 */
public class Main {

    public static  void  main(String[] args){

        Factory factory = new Factory();

        Product product = factory.create(ProductA.class);
        product.method();
        Product product1 = factory.create(ProductB.class);
        product1.method();

        List<Product> list =  new ArrayList<>();

        list.add(product);
        list.add(product1);

        for (Product item:list
             ) {
           if(null!=item){
               item.method();
           }else {
               System.out.println(">>>product null<<<<");
           }
        }
    }
}
