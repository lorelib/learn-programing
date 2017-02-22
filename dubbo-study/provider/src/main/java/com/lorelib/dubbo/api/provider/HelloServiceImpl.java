package com.lorelib.dubbo.api.provider;

import com.lorelib.dubbo.api.HelloService;

/**
 * Created by listening on 2016/10/20.
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
