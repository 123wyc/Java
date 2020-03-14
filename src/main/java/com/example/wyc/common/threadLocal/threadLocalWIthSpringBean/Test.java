package com.example.wyc.common.threadLocal.threadLocalWIthSpringBean;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@Component
public class Test {

    @Autowired
    private ServletContext servletContext;

    /**
     * spring bean 利用threadlocal 作为上下文
     */
    @org.junit.Test
    public void contextLoads() {

        ServletContext ss = servletContext;
        WebApplicationContext context =
                WebApplicationContextUtils.getWebApplicationContext(ss);

        BeanOne bean1 = (BeanOne) context.getBean("beanOne");
        bean1.invoke();
        BeanTwo bean2 = (BeanTwo) context.getBean("beanTwo");
        bean2.invoke();
    }


    /**
     * 打印结果会是：子线程中get key1 的value，值为null
     * 因为创建子线程的时候并不会copy父线程threadLocal的值
     */
    @org.junit.Test
    public void test2() {
        ServletContext ss = servletContext;
        WebApplicationContext context =
                WebApplicationContextUtils.getWebApplicationContext(ss);
        BeanOne bean1 = (BeanOne) context.getBean("beanOne");
        bean1.invoke();
        BeanThree bean3 = (BeanThree) context.getBean("beanThree");
        bean3.invoke();

    }

    /**
     *   public static final ThreadLocal<Map<String, String>> CACHE = new InheritableThreadLocal<>();
     *
     *    在创建子线程的时候就可以获取到父线程的threadLocal的值
     */
    @org.junit.Test
    public void test3() {
        ServletContext ss = servletContext;
        WebApplicationContext context =
                WebApplicationContextUtils.getWebApplicationContext(ss);

        BeanFour bean4 = (BeanFour) context.getBean("beanFour");
        bean4.invoke();
        BeanFive bean5 = (BeanFive) context.getBean("beanFive");
        bean5.invoke();

    }
}
