package com.lorelib.java.jmx.standard;

/**
 * Created by listening on 2017/3/3.
 */
public interface HelloMBean {
    void sayHello();

    int add(int x, int y);

    String getName();

    int getCacheSize();

    void setCacheSize(int size);
}
