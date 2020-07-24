package com.example.wyc.DesignPatterns.prototype;

/**
 * @author wyc
 * @date 2020/6/1/16:48
 */
public class Client {

    public static void main(String[] args) {

        Area area = new Area();
        area.setUnit("RMB");

        // 原型实例，100RMB的钞票
        Money money = new Money(100, area);

        for (int i = 1; i <= 3; i++) {
            try {
                Money cloneMoney = money.clone();
                cloneMoney.setFaceValue(i * 100);
                System.out.println("这张是" + cloneMoney.getFaceValue() +  cloneMoney.getArea().getUnit() + "的钞票");
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
    }
}
