package com.lorelib.guava.eventbus;

/**
 * 创建订单事件
 * Created by listening on 2017/2/14.
 */
public class CreateOrderEvent {
    private final Order order;

    public CreateOrderEvent(final Order order) {
        System.out.println("生成订单事件【订单ID: " + order.getId() + ", 订单时间: " + order.getOrderTime().toLocaleString() + "】");
        this.order = order;
    }

    public Order order() {
        return this.order;
    }
}
