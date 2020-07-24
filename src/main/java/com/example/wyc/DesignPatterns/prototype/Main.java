package com.example.wyc.DesignPatterns.prototype;

/**
 * @author wyc
 * @date 2020/6/1/16:34
 */
public class Main {
    /**
     * 定义  用原型实例指定所有创建对象的类型，并且通过复制这个拷贝创建新的对象。
     * 特点  1）必须存在一个现有的对象，也就是原型实例，通过原型实例创建新对象。
     *   2）在Java中，实现Cloneable，并且因为所有的类都继承Object类，重写clone()方法来实现拷贝。
     *  使用场景
     * 大量的对象，并且类初始化时消耗的资源多。
     *
     * 这些钞票的信息属性基本一致，可以调整个别的属性。
     *
     * 印钞票的工序非常复杂，需要进行繁琐的数据处理
     */
    public static void main(String[] args) {


    }
}
