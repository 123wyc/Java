package com.example.wyc.DesignPatterns.Decorator;

import com.example.wyc.DesignPatterns.Decorator.impl.Boy;
import com.example.wyc.DesignPatterns.Decorator.impl.CheapCloth;
import com.example.wyc.DesignPatterns.Decorator.impl.ExpensiveCloth;

/**
 * @author wyc
 * @date 2020/6/1/15:38
 */
public class Main {
    /**
     *  装饰器模式  可以抽象理解为天冷了穿衣服。需要就加 不需要就脱
     */


    public static void main(String[] args) {
        AbstractPerson person = new Boy();
        PersonCloth clothCheap = new CheapCloth(person);
         clothCheap.dressed();
        //PersonCloth clothExpensive = new ExpensiveCloth(clothCheap);
       PersonCloth clothExpensive = new ExpensiveCloth(new CheapCloth(person));
        clothExpensive.dressed();
    }

}
