package com.example.wyc.DesignPatterns.Decorator.impl;

import com.example.wyc.DesignPatterns.Decorator.AbstractPerson;
import com.example.wyc.DesignPatterns.Decorator.PersonCloth;

/**
 * @author wyc
 * @date 2020/6/1/16:02
 */
public class CheapCloth extends PersonCloth {

    public CheapCloth(AbstractPerson person) {
        super(person);
    }

    @Override
    public void dressed(){
        super.dressed();
        dressShorts();
    }

    private void dressShorts() {
        System.out.println("穿条短裤");
    }

}
