package com.ny.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.core.Ordered;

//@Aspect
//@Component
public class AopInterceptor1 implements Ordered {

    @AfterReturning(
            pointcut = "com.ny.aop.AopArchitecture.anyPublicOperation()",
            returning = "retVal"
    )
    public void interceptor(Object retVal) {
        System.out.println("I'm interceptor 1, retVal=" + retVal);
    }

    @Override
    public int getOrder() {
        return 90;
    }
}
