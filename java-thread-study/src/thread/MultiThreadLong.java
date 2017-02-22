package thread;

/**
 * @Description:
 * @User: luomm
 * @Version: V1.0 beta 1
 * @Date: 2016/4/24.
 */
public class MultiThreadLong {
    public static double t = 0;
    public static class ChangeT implements Runnable {
        private double to;
        public ChangeT(double to) {
            this.to = to;
        }
        @Override
        public void run() {
            while (true) {
                MultiThreadLong.t = to;
                Thread.yield();
            }
        }
    }
    public static class ReadT implements Runnable {
        @Override
        public void run() {
            while (true) {
                double tmp = MultiThreadLong.t;
                if (tmp != 111 && tmp != -999 && tmp != 333 && tmp != -444) {
                    System.out.println(tmp);
                }
                Thread.yield();
            }
        }
    }
    public static void main(String[] args) {
        new Thread(new ChangeT(111)).start();
        new Thread(new ChangeT(-999)).start();
        new Thread(new ChangeT(-444)).start();
        new Thread(new ChangeT(333)).start();
        new Thread(new ReadT()).start();
    }
}
