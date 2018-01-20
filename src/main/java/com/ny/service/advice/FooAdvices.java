package com.ny.service.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Aspect
@Component
public class FooAdvices {

    Logger logger = LoggerFactory.getLogger(FooAdvices.class);

    @PersistenceContext(unitName = "default")
    private EntityManager em;

//     @Before("com.ny.aop.AopArchitecture.fooService() && args(name, ..)")
//     public void beforeAdd(String name) {
//         logger.debug("Before add foo, name:{}", name);
//     }

//     @Around("com.ny.aop.AopArchitecture.fooService() && args(name, ..)")
//     public Object aroundAdd(ProceedingJoinPoint pjp, String name) throws Throwable {
//         logger.debug("Around add foo, name:{}, add another", name);
// //        FooEntity foo = new FooEntity();
// //        em.persist(foo);
//         return pjp.proceed();
//     }

    @Before("com.ny.aop.AopArchitecture.fooService() && execution(public * findByName(..)) && args(name)")
    public void beforeFind(String name) {
        logger.info("Before find foof:{}", name);
    }
}
