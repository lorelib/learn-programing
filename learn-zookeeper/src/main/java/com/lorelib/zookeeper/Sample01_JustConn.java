package com.lorelib.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author listening
 * @description Sample01_JustConn:
 * @create 2017 04 13 18:21.
 */
public class Sample01_JustConn implements Watcher {
    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

    public static void main(String[] args) throws IOException {
        ZooKeeper zk = new ZooKeeper("127.0.0.1:2181", 5000, new Sample01_JustConn());
        System.out.println(zk.getState());
        try {
            connectedSemaphore.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ZK session established.");
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("Receive watched event: " + watchedEvent);
        if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
            connectedSemaphore.countDown();
            System.out.println("Connected to ZK");
        }
    }
}
