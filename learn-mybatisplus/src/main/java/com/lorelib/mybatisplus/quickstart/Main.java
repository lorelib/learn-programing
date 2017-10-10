package com.lorelib.mybatisplus.quickstart;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author listening
 * @description
 * @date 2017-10-09 10:42
 * @since 1.1
 */
public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        context.start();

        UserService userService = (UserService) context.getBean("userService");
        userService.insert();
    }
}
