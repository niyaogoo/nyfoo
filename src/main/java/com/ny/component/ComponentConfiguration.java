package com.ny.component;

import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component
public class ComponentConfiguration {

    @Bean
    @Qualifier("public")
//    @Scope("prototype")
    public ComponentBean publicBean(InjectionPoint injectionPoint) {
        System.out.println("instance for" + injectionPoint.getMember());
        return new ComponentBean("instance for" + injectionPoint.getMember());
    }

    @Bean
    protected ComponentBean protectedInstance(
            @Autowired @Qualifier("public") ComponentBean publicBean) {
        return new ComponentBean("protected");
    }


}
