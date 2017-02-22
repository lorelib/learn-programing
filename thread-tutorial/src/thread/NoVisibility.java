package thread;

/**
 * Created by lorelib on 2016/5/15.
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;
    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                System.out.println(number);
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        Thread.sleep(100);
        number = 42;
        ready = true;
        Thread.sleep(1000);
    }
}
