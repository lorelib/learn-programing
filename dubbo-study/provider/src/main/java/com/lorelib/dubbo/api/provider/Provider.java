package com.lorelib.dubbo.api.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by listening on 2016/10/28.
 */
public class Provider {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]
                {"provider.xml"});
        ctx.start();

        System.in.read();
    }
}
