package com.lorelib.rpc.hessian;

import java.io.Serializable;

/**
 * Created by listening on 2017/1/7.
 */
public class User implements Serializable {
    private int id;
    private String userId;
    private String userName;

    public User() {}

    public User(int id, String userId, String userName) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
