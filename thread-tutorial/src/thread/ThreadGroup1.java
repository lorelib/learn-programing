package thread;

/**
 * Created by lorelib on 2016/5/15.
 */
public class ThreadGroup1 implements Runnable {
    @Override
    public void run() {
        String groupAndName = Thread.currentThread().getThreadGroup().getName()
                + "-" + Thread.currentThread().getName();
        while (true) {
            System.out.println("I am " + groupAndName);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("PrintGroup");
        Thread t1 = new Thread(group, new ThreadGroup1(), "T1");
        Thread t2 = new Thread(group, new ThreadGroup1(), "T2");
        t1.start();
        t2.start();
        System.out.println(group.activeCount());
        group.list();
    }
}
