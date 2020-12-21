package thread;

/**
 * @author: lixiaoshuang
 * @create: 2020-12-21 14:33
 **/
public class DaemonThread {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread t = Thread.currentThread();
            System.out.println("当前线程:" + t.getName());
        };
        Thread thread = new Thread(runnable);
        thread.setName("test-thread-1");
        thread.setDaemon(false);
        thread.start();
    }
}
