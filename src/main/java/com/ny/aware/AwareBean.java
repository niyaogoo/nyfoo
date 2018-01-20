package com.ny.aware;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * spring aware test
 */
public class AwareBean implements ApplicationContextAware, BeanNameAware {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.debug("Set ApplicationContext");
    }

    @Override
    public void setBeanName(String name) {
        logger.debug("Set BeanName:{}", name);
    }
}
