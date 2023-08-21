package com.demo_jpa_c04.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectDemo {

    @Before("within(com.demo_jpa_c04.controller.ProductController)")
    public void start(){
        System.out.println("----------------");
        System.out.println(1);
        System.out.println("----------------");
    }

    @After("within(com.demo_jpa_c04.controller.ProductController)")
    public void end(){
        System.out.println("----------------");
        System.out.println(2);
        System.out.println("----------------");
    }

}
