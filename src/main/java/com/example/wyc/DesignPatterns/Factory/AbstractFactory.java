package com.example.wyc.DesignPatterns.Factory;

/**
 * @author wyc
 * @date 2020/6/1/12:58
 */
public  abstract  class AbstractFactory<T> {

    abstract  Product create(Class<T> clazz);
}
