package concurrentthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by lorelib on 2016/5/29.
 */
public class SemapDemo implements Runnable {
    final Semaphore semp = new Semaphore(5);
    @Override
    public void run() {
        try {
            semp.acquire();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " :done!");
            semp.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(20);
        final SemapDemo demo = new SemapDemo();
        for (int i = 0; i < 20; i++) {
            exec.submit(demo);
        }
    }
}
