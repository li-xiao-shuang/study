package thread;

/**
 * @author: lixiaoshuang
 * @create: 2020-12-21 14:45
 **/
public class RunnableMain {
    public static void main(String[] args) {
        RunnableDemo1 runner1 = new RunnableDemo1();
        Thread thread1 = new Thread(runner1);

        RunnableDemo2 runner2 = new RunnableDemo2();
        Thread thread2 = new Thread(runner2);

        thread1.start();
        thread2.start();

        thread2.interrupt();  // i = true

        System.out.println(Thread.activeCount());

        Thread.currentThread().getThreadGroup().list();
        System.out.println(Thread.currentThread().getThreadGroup().getParent().activeGroupCount());
        Thread.currentThread().getThreadGroup().getParent().list();
    }
}
