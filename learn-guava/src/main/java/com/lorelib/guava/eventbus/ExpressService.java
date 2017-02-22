package com.lorelib.guava.eventbus;

import com.google.common.collect.Lists;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import java.util.List;

/**
 * 快递服务
 * Created by listening on 2017/2/14.
 */
public class ExpressService {
    private List<CreateOrderEvent> events = Lists.newArrayList();

    public ExpressService(EventBus eventBus) {
        eventBus.register(this);
    }

    /**
     * 发货
     */
    @Subscribe
    public void deliverGoods(CreateOrderEvent createOrderEvent) {
        System.out.println("准备发货...");
        Order order = createOrderEvent.order();
        System.out.println("发货信息【订单ID: " + order.getId() + ", 订单时间: " + order.getOrderTime().toLocaleString() + "】");
    }
}
