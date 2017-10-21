package com.lorelib.dubbo.consumer;

import com.lorelib.dubbo.api.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by listening on 2016/10/28.
 */
public class Consumer {
  public static void main(String[] args) {
    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("consumer.xml");
    ctx.start();

    HelloService helloService = (HelloService) ctx.getBean("helloService");
    String hello = helloService.sayHello("listening");
    System.out.println(hello);
  }
}
