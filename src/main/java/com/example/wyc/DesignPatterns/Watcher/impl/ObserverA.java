package com.example.wyc.DesignPatterns.Watcher.impl;

import com.example.wyc.DesignPatterns.Watcher.AbstractObserver;

/**
 * @author wyc
 * @date 2020/6/1/14:30
 */
public  class ObserverA extends AbstractObserver {

    @Override
    public void update(String msg) {
        System.out.println("Observer A  update!");
    }

    @Override
    public String getName() {
        return "observer A";
    }
}
