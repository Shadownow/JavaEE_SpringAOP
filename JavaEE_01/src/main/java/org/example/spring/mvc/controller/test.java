package org.example.spring.mvc.controller;

import org.example.spring.mvc.service.testService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.FileSystemXmlApplicationContext;

@EnableAspectJAutoProxy
public class test {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("/JavaEE_01/src/main/webapp/WEB-INF/applicationContext.xml");
        testService testService = (testService)context.getBean("testService");
        testService.testAdd(Long.valueOf(123123),"李狗");
    }
}
