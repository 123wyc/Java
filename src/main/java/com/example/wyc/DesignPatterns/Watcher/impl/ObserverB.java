package com.example.wyc.DesignPatterns.Watcher.impl;

import com.example.wyc.DesignPatterns.Watcher.AbstractObserver;

/**
 * @author wyc
 * @date 2020/6/1/14:30
 */
public  class ObserverB extends AbstractObserver {

    @Override
    public void update(String msg) {
        System.out.println("Observer B update!");
    }

    @Override
    public String getName() {
        return "observer B";
    }
}
