package com.example.wyc.DesignPatterns.Watcher;

/**
 * @author wyc
 * @date 2020/6/1/14:18
 */
public  abstract  class AbstractObserver {
    /**
     * 观察者的抽象类
     */
    /**
     *
     * @return
     */
    public abstract String getName();

    /**
     * 通知更新方法
     *
     * @param msg
     */
    public abstract void update(String msg);

}
