package concurrentthread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lorelib on 2016/5/28.
 */
public class TimeLock implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        try {
            if (lock.tryLock(5, TimeUnit.SECONDS)) {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(6000);
            } else {
                System.out.println(Thread.currentThread().getName());
                System.out.println("get lock failed");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock.isHeldByCurrentThread()) lock.unlock();
        }
    }
    public static void main(String[] args) {
        TimeLock t = new TimeLock();
        Thread t1 = new Thread(t, "t1");
        Thread t2 = new Thread(t, "t2");
        t1.start();
        t2.start();
    }
}
