package com.lorelib.guava.eventbus;

import com.google.common.eventbus.EventBus;

import java.util.Date;

/**
 * 订单服务
 * Created by listening on 2017/2/14.
 */
public class OrderService {
    private EventBus eventBus;

    public OrderService(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void createOrder() {
        Order order = new Order("DN20170214", new Date());
        System.out.println("创建订单【订单ID: " + order.getId() + ", 订单时间: " + order.getOrderTime().toLocaleString() + "】");
        CreateOrderEvent event = new CreateOrderEvent(order);
        eventBus.post(event);
        System.out.println("订单创建完成！");
    }
}
