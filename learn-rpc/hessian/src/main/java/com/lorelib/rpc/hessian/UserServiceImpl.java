package com.lorelib.rpc.hessian;

/**
 * Created by listening on 2017/1/7.
 */
public class UserServiceImpl implements UserService {
    @Override
    public String getUserName(long companyId, String userId) {
        System.out.println("companyId = " + companyId + ", userId = " + userId);
        return "luomm";
    }

    @Override
    public User getUser(String userId) {
        System.out.println("userId = " + userId);
        User user = new User(1, "listening", "luomm");
        return user;
    }
}
