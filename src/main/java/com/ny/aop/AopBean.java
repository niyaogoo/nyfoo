package com.ny.aop;

import org.springframework.stereotype.Component;

@Component
public class AopBean {

    public String hello() {
        try {
            throw new Exception();
//            return "hello";
        } catch (Exception e) {
            return "exception";
        } finally {
//            return "finally";
        }
    }

}
