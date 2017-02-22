package com.lorelib.rpc.thrift;

import org.apache.thrift.TException;

/**
 * Created by listening on 2017/1/6.
 */
public class UserServiceImpl implements UserService.Iface {
    @Override
    public String getUserName(long companyId, String userId) throws TException {
        System.out.println("companyId = " + companyId + ", userId = " + userId);
        return "luomm";
    }

    @Override
    public User getUser(String userId) throws TException {
        System.out.println("userId = " + userId);
        User user = new User(1, "listening", "luomm");
        return user;
    }
}
