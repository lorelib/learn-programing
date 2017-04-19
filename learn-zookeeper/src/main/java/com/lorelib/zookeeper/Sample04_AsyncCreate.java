package com.lorelib.zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author listening
 * @description Sample04_AsyncCreate:
 * @create 2017 04 19 13:37.
 */
public class Sample04_AsyncCreate implements Watcher {
    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

    public static void main(String[] args) throws IOException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181",
                5000, new Sample04_AsyncCreate());
        connectedSemaphore.await();
        zooKeeper.create("/zk-test-ephemeral-", "".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL,
                new IStringCallback(), "I am context.");

        zooKeeper.create("/zk-test-ephemeral-", "".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL,
                new IStringCallback(), "I am context.");

        zooKeeper.create("/zk-test-ephemeral-", "".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL,
                new IStringCallback(), "I am context.");

        Thread.sleep(10000);
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
            connectedSemaphore.countDown();
        }
    }
}
class IStringCallback implements AsyncCallback.StringCallback {
    @Override
    public void processResult(int rc, String path, Object ctx, String name) {
        System.out.println("Create path result: [" + rc + ", " + path + ", "
                + ctx + ", real path name: " + name);
    }
}