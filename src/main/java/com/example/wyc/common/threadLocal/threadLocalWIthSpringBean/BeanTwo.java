package com.example.wyc.common.threadLocal.threadLocalWIthSpringBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BeanTwo implements DomainAbilityBean {


    @Override
    public void invoke() {
        String value = ContextCache.getAttribute("key1");
        Logger logger = LoggerFactory.getLogger(BeanTwo.class);
        System.out.println("BeanTwo is run ,thread name id "+ Thread.currentThread().getName());
        logger.info("get key1 value : " + value);
    }
}
