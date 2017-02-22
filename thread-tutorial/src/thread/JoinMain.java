package thread;

/**
 * Created by lorelib on 2016/5/15.
 */
public class JoinMain {
    volatile static int i = 0;
    public static class AddThread extends Thread {
        @Override
        public void run() {
            for(i = 0; i < 1000; i++);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        AddThread t = new AddThread();
        t.start();
        t.join();
        System.out.println("-----------------i = " + i);
    }
}
