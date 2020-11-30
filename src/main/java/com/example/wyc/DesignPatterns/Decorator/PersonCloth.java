package com.example.wyc.DesignPatterns.Decorator;



import java.time.LocalDateTime;

/**
 * @author wyc
 * @date 2020/6/1/15:53
 */
public abstract  class PersonCloth  extends AbstractPerson{
    /**
     * 装饰器 基础类
     */
    /**
     * // 保持一个对 Person 对象的引用
     */
    protected AbstractPerson mPerson;

    public PersonCloth(AbstractPerson mPerson) {
        this.mPerson = mPerson;
    }

    @Override
    public void dressed(){
        int st = LocalDateTime.now().getSecond();
        mPerson.dressed();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int et =  LocalDateTime.now().getSecond();

        System.out.println(et -st);
    }


}
