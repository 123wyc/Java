package com.example.wyc.DesignPatterns.Watcher;

import com.example.wyc.DesignPatterns.Watcher.impl.ObserverA;
import com.example.wyc.DesignPatterns.Watcher.impl.ObserverB;
import com.example.wyc.DesignPatterns.Watcher.impl.SubjectA;

/**
 * @author wyc
 * @date 2020/6/1/14:48
 */
public class Main {

    /**
     * 与Spring整合的版本 参考 策略模式（strategy）
     * @param args
     */
    public static void main(String[] args){

        SubjectA subject = new SubjectA();
        subject.attach(new ObserverA());
        subject.attach(new ObserverB());
        subject.invade();


    }
}
