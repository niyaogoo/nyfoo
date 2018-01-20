package com.ny;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, CacheAutoConfiguration.class})
@ComponentScan
//@EnableLoadTimeWeaving
@EnableJpaRepositories(enableDefaultTransactions = false)
@EnableEurekaClient
public class StartServer {

    public static void main(String[] args) {

        SpringApplication.run(StartServer.class, args);
//        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"beans.xml"});
//        ctx.registerShutdownHook();
//        SingletonBean sb = ctx.getBean(SingletonBean.class);
//        System.out.println(sb.sayName());
//        System.out.println(sb.sayName());
//        System.out.println(sb.sayName());
//        String message = ctx.getMessage("argument.required", new Object[]{"姓名"},
//                "default message", null);
//        System.out.println(message);
//        AopBean aopBean = ctx.getBean(AopBean.class);
//        System.out.println(aopBean.hello());
    }
}
