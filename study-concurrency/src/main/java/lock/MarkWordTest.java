package lock;

import lombok.SneakyThrows;
import org.openjdk.jol.info.ClassLayout;

/**
 * @author: lixiaoshuang
 * @create: 2020-12-22 11:18
 **/
public class MarkWordTest {

    private static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        Thread threadA = new Thread(task);
        Thread threadB = new Thread(task);
        Thread threadC = new Thread(task);
        threadA.start();
        threadA.join();
        threadB.start();
        threadC.start();
    }

    private static class Task extends Thread {

        @SneakyThrows
        @Override
        public void run() {
            synchronized (object) {
                System.out.println("==================="+Thread.currentThread().getId()+" ");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(ClassLayout.parseInstance(object).toPrintable());
            }
        }
    }
}
