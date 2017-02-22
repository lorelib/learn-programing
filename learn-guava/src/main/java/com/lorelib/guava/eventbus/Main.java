package com.lorelib.guava.eventbus;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by listening on 2017/2/14.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        EventBus eventBus = new EventBus();
        OrderService orderService = new OrderService(eventBus);
        new ExpressService(eventBus);
        orderService.createOrder();

        System.out.println(" ---------------------- ");
        Thread.sleep(1000);

        ExecutorService executor = Executors.newFixedThreadPool(1);
        EventBus eventBus1 = new AsyncEventBus("orderBus", executor);
        OrderService orderService1 = new OrderService(eventBus1);
        new ExpressService(eventBus1);
        orderService1.createOrder();
    }
}
