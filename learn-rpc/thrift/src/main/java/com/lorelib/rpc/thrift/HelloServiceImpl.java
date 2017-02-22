package com.lorelib.rpc.thrift;

import org.apache.thrift.TException;

/**
 * 接口实现
 * Created by listening on 2017/1/5.
 */
public class HelloServiceImpl implements HelloService.Iface {
    private static int count = 0;

    @Override
    public String helloString(String word) throws TException {
        count += 1;
        System.out.println("get " + word + " " + count);
        return "get " + word + " " + count;
    }
}
