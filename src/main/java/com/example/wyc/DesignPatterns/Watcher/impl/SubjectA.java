package com.example.wyc.DesignPatterns.Watcher.impl;


import com.example.wyc.DesignPatterns.Watcher.Subject;

/**
 * @author wyc
 * @date 2020/6/1/15:18
 */
public class SubjectA extends Subject {

    public void invade(){

        System.out.println("灰太狼：我要搞事情了");
        // 通知所有观察者
        notifyObserver();
    }

}
