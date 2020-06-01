package com.example.wyc.DesignPatterns.Decorator.impl;

import com.example.wyc.DesignPatterns.Decorator.AbstractPerson;

/**
 * @author wyc
 * @date 2020/6/1/15:48
 */
public class Boy extends AbstractPerson {

    /**
     * 具体需要被装饰的类
     */

    @Override
    public void dressed() {
        System.out.println("穿了内衣");
    }
}
