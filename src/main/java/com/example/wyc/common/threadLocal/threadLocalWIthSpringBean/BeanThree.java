package com.example.wyc.common.threadLocal.threadLocalWIthSpringBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BeanThree  implements  DomainAbilityBean{

    Logger logger = LoggerFactory.getLogger(BeanThree.class);
    @Override
    public void invoke() {
      Thread thread = new Thread(( )->{
        logger.info("子线程开启 ，子线程线程名为 {}" ,Thread.currentThread().getName());
          String value = ContextCache.getAttribute("key1");
          logger.info("子线程中get key1 的value，值为{}",value);
      });
        thread.start();
        try {
            // 保证线程执行完毕
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
