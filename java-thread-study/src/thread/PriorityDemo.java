package thread;

/**
 * Created by lorelib on 2016/5/15.
 */
public class PriorityDemo {
    public static class HightPriority extends Thread {
        static int count = 0;
        @Override
        public void run() {
            while (true) {
                synchronized (PriorityDemo.class) {
                    count++;
                    if (count > 100000) {
                        System.out.println("HightPriority is complete");
                        break;
                    }
                }
            }
        }
    }
    public static class LowPriority extends Thread {
        static int count = 0;
        @Override
        public void run() {
            while (true) {
                synchronized (LowPriority.class) {
                    count++;
                    if (count > 100000) {
                        System.out.println("LowPriority is complete");
                        break;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Thread high = new HightPriority();
        Thread low = new LowPriority();
        high.setPriority(Thread.MAX_PRIORITY);
        low.setPriority(Thread.MIN_PRIORITY);
        high.start();
        low.start();
    }
}
