package com.example.demo;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author caiwenhai
 * @version 1.0
 * @date 2020/12/25 13:49
 */

public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static <T> T getBean(Class<T> a){
        return applicationContext.getBean(a);
    }

    public static <T> T getBean(String beanName ,Class<T> a){
        return applicationContext.getBean(beanName,a);
    }


}
