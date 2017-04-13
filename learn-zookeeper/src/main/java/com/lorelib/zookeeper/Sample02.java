package com.lorelib.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author listening
 * @description Sample02:
 * @create 2017 04 13 18:38.
 */
public class Sample02 implements Watcher {
    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

    public static void main(String[] args) throws IOException {
        String connect = "127.0.0.1:2181";
        ZooKeeper zk = new ZooKeeper(connect, 5000, new Sample02());
        System.out.println(zk.getState());
        try {
            connectedSemaphore.await();
            long sessionId = zk.getSessionId();
            byte[] pwd = zk.getSessionPasswd();
            System.out.println("sessionId: " + sessionId + ", pwd: " + pwd);

            zk = new ZooKeeper(connect, 5000, new Sample02(), 1L, "test".getBytes());

            zk = new ZooKeeper(connect, 5000, new Sample02(), sessionId, pwd);

            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("Received watch event: " + watchedEvent);
        if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
            connectedSemaphore.countDown();
        }
    }
}
