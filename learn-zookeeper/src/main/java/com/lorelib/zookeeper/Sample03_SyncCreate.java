package com.lorelib.zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author listening
 * @description Sample03_SyncCreate:
 * @create 2017 04 14 12:24.
 */
public class Sample03_SyncCreate implements Watcher {
    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

    public static void main(String[] args) throws IOException {
        final String connect = "127.0.0.1:2181";
        ZooKeeper zk = new ZooKeeper(connect, 5000, new Sample03_SyncCreate());
        System.out.println(zk.getState());
        try {
            connectedSemaphore.await();
            String path1 = zk.create("/zk-ephemeral2-", "".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE,
                    CreateMode.EPHEMERAL);
            System.out.println("Success create znode: " + path1);

            String path2 = zk.create("/zk-ephemeral2-", "".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE,
                    CreateMode.EPHEMERAL_SEQUENTIAL);
            System.out.println("Success create znode: " + path2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("received event: " + watchedEvent.toString());
        if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
            connectedSemaphore.countDown();
        }
    }
}
