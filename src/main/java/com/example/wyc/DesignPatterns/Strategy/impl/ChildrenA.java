package com.example.wyc.DesignPatterns.Strategy.impl;

import com.example.wyc.DesignPatterns.Strategy.ParentInterface;
import org.springframework.stereotype.Service;

/**
 * @author wyc
 * @date 2020/6/1/13:51
 */
@Service
public class ChildrenA implements ParentInterface {

    @Override
    public Integer assetType() {
        return 1;
    }

    @Override
    public void method() {
        System.out.println(">>>>>>这里是Children A ! <<<<<<");
    }
}
