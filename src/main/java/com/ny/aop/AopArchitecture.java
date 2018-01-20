package com.ny.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect
@EnableAspectJAutoProxy
@Configuration
public class AopArchitecture {

    private String name;

    @Pointcut("within(com.ny.service.FooService)")
    public void fooService() {
    }

    // @Pointcut("within(com.ny.service.FooService) && execution(public * add(..)) ")
    // public void fooService() {

    // }

}
