package com.lorelib.java.jmx.standard;

import javax.management.*;
import java.lang.management.ManagementFactory;

/**
 * Created by listening on 2017/3/3.
 */
public class Main {
    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        //mbs = MBeanServerFactory.createMBeanServer();
        ObjectName name = new ObjectName("com.lorelib.java.jmx.standard:type=Hello");
        Hello mbean = new Hello();
        mbs.registerMBean(mbean, name);

        System.out.println("Waiting forever...");
        Thread.sleep(Long.MAX_VALUE);
    }
}
