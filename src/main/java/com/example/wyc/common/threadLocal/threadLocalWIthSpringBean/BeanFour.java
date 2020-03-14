package com.example.wyc.common.threadLocal.threadLocalWIthSpringBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BeanFour implements DomainAbilityBean {


    Logger logger = LoggerFactory.getLogger(BeanFour.class);

    @Override
    public void invoke() {
        ContextCacheInhertable.putAttribute("key1", "value1");
        System.out.println("BeanFour is run ,thread name id " + Thread.currentThread().getName());
        logger.info("BeanFour is run ,thread name id " + Thread.currentThread().getName());

    }
}
