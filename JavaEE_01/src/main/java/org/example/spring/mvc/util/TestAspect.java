package org.example.spring.mvc.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

@Component
@Aspect
public class TestAspect {
    @Pointcut("execution(* org.example.spring.mvc.service.*.*(..))")
    public void pointcut(){};


    @Before("pointcut()")
    public void beforeService(){
        System.out.println("this is before");
    }


    @After("pointcut()")
    public void afterService(){
        System.out.println("this is after");
    }

    @Around("pointcut()")
    public void aroundService(ProceedingJoinPoint pj){
        Object object = null;
        try {

            object = pj.proceed();
            Connection connection = (Connection) object;
            if(object==null){
                System.out.println("数据成功插入！");
            }
            else{
                try {
                    if (connection != null) {
                        connection.rollback();
                        System.out.println("数据插入失败！已回滚");
                    }
                } catch (SQLException e1) {
                    System.out.println(e1);
                }
            }

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

}
