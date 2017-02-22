package com.lorelib.rpc.hessian;

/**
 * Created by listening on 2017/1/7.
 */
public interface UserService {
    String getUserName(long companyId, String userId);

    User getUser(String userId);
}
