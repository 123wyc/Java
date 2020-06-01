package com.example.wyc.DesignPatterns.Factory;

/**
 * @author wyc
 * @date 2020/6/1/13:05
 */
public class Factory extends AbstractFactory {
    @Override
    Product create(Class clazz) {
        try{

            Object object = Class.forName(clazz.getName()).newInstance();
            if(object instanceof  Product){

                return (Product)object;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
