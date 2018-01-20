package com.ny.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * for life cycle test
 */
public class LifeCycleBean {

    Logger logger = LoggerFactory.getLogger(getClass());

    public void init() {
        logger.debug("Init");
    }

    public void destroy() {
        logger.debug("Destroy");
    }
}
