package com.example.wyc.DesignPatterns.Watcher;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wyc
 * @date 2020/6/1/14:24
 */
public abstract class Subject {

    /**
     * 被观察者
     */

    /**
     * 观察者对象的集合
     */
    private List<AbstractObserver> observerList = new ArrayList<>();

    /**
     * 登记观察者
     *
     * @param observer
     */
    public void attach(AbstractObserver observer) {
        observerList.add(observer);
        System.out.println("增加了观察者：" + observer.getName());
    }

    /**
     * 删除观察者
     *
     * @param observer
     */
    public void dettach(AbstractObserver observer) {
        observerList.remove(observer);
        System.out.println("删除了观察者：" + observer.getName());
    }

    /**
     * 通知所有观察者
     */
    public void notifyObserver() {
        for (AbstractObserver observer : observerList) {
            observer.update("灰太狼要搞事情了");
        }
    }

}
