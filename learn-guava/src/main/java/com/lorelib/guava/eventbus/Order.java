package com.lorelib.guava.eventbus;

import java.util.Date;

/**
 * 订单
 * Created by listening on 2017/2/14.
 */
public class Order {
    private String id;
    private Date orderTime;

    public Order() {}

    public Order(final String id, final Date orderTime) {
        this.id = id;
        this.orderTime = orderTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }
}
