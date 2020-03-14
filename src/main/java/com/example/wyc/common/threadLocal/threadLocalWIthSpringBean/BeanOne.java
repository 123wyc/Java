package com.example.wyc.common.threadLocal.threadLocalWIthSpringBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BeanOne implements DomainAbilityBean {
     Logger logger = LoggerFactory.getLogger(BeanOne.class);
    @Override
    public void invoke() {
        ContextCache.putAttribute("key1","value1");
        System.out.println("BeanOne is run ,thread name id "+ Thread.currentThread().getName());
        logger.info("BeanOne is run ,thread name id "+ Thread.currentThread().getName());
    }
}
