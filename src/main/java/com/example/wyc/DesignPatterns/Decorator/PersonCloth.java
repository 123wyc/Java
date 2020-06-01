package com.example.wyc.DesignPatterns.Decorator;

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
        mPerson.dressed();
    }


}
