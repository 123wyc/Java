package com.example.wyc.DesignPatterns.Decorator.impl;

import com.example.wyc.DesignPatterns.Decorator.AbstractPerson;
import com.example.wyc.DesignPatterns.Decorator.PersonCloth;

/**
 * @author wyc
 * @date 2020/6/1/15:59
 */
public class ExpensiveCloth extends PersonCloth {

    public ExpensiveCloth(AbstractPerson mPerson) {
        super(mPerson);
    }

    @Override
    public void dressed() {
        super.dressed();
        dressLeather();
        dressJean();
    }

    private void dressLeather() {
        System.out.println("穿件皮衣");
    }

    private void dressJean() {
        System.out.println("穿条牛仔裤");
    }
}
