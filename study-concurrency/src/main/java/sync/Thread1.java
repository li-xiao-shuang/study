
package sync;

public class Thread1 implements Runnable {

    public Object object = new Object();

    @Override
    public void run() {
        synchronized (Thread1.class) {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " synchronized loop " + i);
            }
        }
    }

    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread1 t2 = new Thread1();
        Thread ta = new Thread(t1, "A");
        Thread tb = new Thread(t2, "B");
        ta.start();
        tb.start();
    }
}
