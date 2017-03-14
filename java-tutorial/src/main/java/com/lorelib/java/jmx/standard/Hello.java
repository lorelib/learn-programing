package com.lorelib.java.jmx.standard;

/**
 * Created by listening on 2017/3/3.
 */
public class Hello implements HelloMBean {
    private int cacheSize = 0;

    @Override
    public void sayHello() {
        System.out.println("Hello World!");
    }

    @Override
    public int add(int x, int y) {
        return x + y;
    }

    @Override
    public String getName() {
        return "listening";
    }

    @Override
    public int getCacheSize() {
        return cacheSize;
    }

    @Override
    public void setCacheSize(int size) {
        this.cacheSize = size;
    }
}
