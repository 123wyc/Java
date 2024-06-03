package com.example.wyc.DesignPatterns.Strategy;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author wyc
 * @date 2020/6/1/13:43
 */
@RestController
public class Main {
    /**
     * 策略模式结合spring的使用
     */
    @Resource
    private  ParentInterface[] childrens;

    @RequestMapping("/strategy")
    public  void StrategyMain(){

        for (ParentInterface children: childrens
             ) {
                if(children.assetType()>0){
                    children.method();
                }else{
                    System.out.println(">>>>>type == 0<<<<<");
                }
        }
    }
}
