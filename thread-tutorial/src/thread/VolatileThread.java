package thread;

/**
 * Created by lorelib on 2016/5/15.
 */
public class VolatileThread {
    volatile static int i = 0;
    public static class PlusTask implements Runnable {
        @Override
        public void run() {
            for (int k = 0; k < 100000; k++) {
                i++;
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new PlusTask());
            threads[i].start();
        }
        for (int i = 0; i < 10; i++) {
            threads[i].join();
        }
        System.out.println("i = " + i);
    }
}
