package com.example.wyc.DesignPatterns.Strategy.impl;

import com.example.wyc.DesignPatterns.Strategy.ParentInterface;
import org.springframework.stereotype.Service;

/**
 * @author wyc
 * @date 2020/6/1/14:00
 */
@Service
public class ChildrenB implements ParentInterface {

    @Override
    public Integer assetType() {
        return 0;
    }

    @Override
    public void method() {
        System.out.println(">>>>>>这里是children B !<<<<<<");
    }
}
