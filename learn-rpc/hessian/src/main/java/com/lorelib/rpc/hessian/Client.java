package com.lorelib.rpc.hessian;

import com.caucho.hessian.client.HessianProxyFactory;

import java.net.MalformedURLException;

/**
 * Created by listening on 2017/1/7.
 */
public class Client {
    public static void main(String[] args) throws MalformedURLException {
        String url = "http://localhost:8080/hessian/user";
        HessianProxyFactory factory = new HessianProxyFactory();
        UserService userService = (UserService) factory.create(UserService.class, url);
        User user = userService.getUser("listening");
        System.out.println(user.getUserName() + "  " + user.getUserId());
    }
}
