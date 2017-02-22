package thread;

/**
 * Created by lorelib on 2016/5/10.
 */
public class InterruptThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Thread interrupted!");
                        break;
                    }
                    Thread.yield();
                    System.out.println(System.currentTimeMillis());
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted when sleep");;
                        Thread.currentThread().interrupt();
                    }
                }
            }
        };
        t1.start();
        t1.sleep(1000);
        t1.interrupt();
    }
}
