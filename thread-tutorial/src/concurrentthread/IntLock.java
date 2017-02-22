package concurrentthread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lorelib on 2016/5/26.
 */
public class IntLock implements Runnable {
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    int lock;
    public IntLock(int lock) {
        this.lock = lock;
    }
    @Override
    public void run() {
        try {
            if (lock == 1) {
                lock1.lockInterruptibly();
                System.out.println("t1 get lock1");
                Thread.sleep(500);
                lock2.lockInterruptibly();
                System.out.println("t1 get lock2");
            } else {
                lock2.lockInterruptibly();
                System.out.println("t2 get lock2");
                Thread.sleep(500);
                lock1.lockInterruptibly();
                System.out.println("t2 get lock1");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock1.isHeldByCurrentThread()) lock1.unlock();
            if (lock2.isHeldByCurrentThread()) lock2.unlock();
            System.out.println(Thread.currentThread().getName() + ":线程退出");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        IntLock r1 = new IntLock(1);
        IntLock r2 = new IntLock(2);
        Thread t1 = new Thread(r1, "t1");
        Thread t2 = new Thread(r2, "t2");
        t1.start();
        t2.start();
        Thread.sleep(1000);
        t2.interrupt();
    }
}
/**
 t1 get lock1
 t2 get lock2
 java.lang.InterruptedException
 t2:线程退出
 t1 get lock2
 at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireInterruptibly(AbstractQueuedSynchronizer.java:896)
 t1:线程退出
 at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireInterruptibly(AbstractQueuedSynchronizer.java:1221)
 at java.util.concurrent.locks.ReentrantLock.lockInterruptibly(ReentrantLock.java:340)
 at concurrentthread.IntLock.run(IntLock.java:28)
 at java.lang.Thread.run(Thread.java:745)
 */