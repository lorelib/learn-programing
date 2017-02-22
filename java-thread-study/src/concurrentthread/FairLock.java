package concurrentthread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lorelib on 2016/5/28.
 */
public class FairLock implements Runnable {
    public static ReentrantLock lock = new ReentrantLock(true);
    @Override
    public void run() {
        while(true) {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " 获得锁");
            } finally {
                lock.unlock();
            }
        }
    }
    public static void main(String[] args) {
        FairLock r = new FairLock();
        Thread t1 = new Thread(r, "t1");
        Thread t2 = new Thread(r, "t2");
        t1.start();
        t2.start();
    }
}
