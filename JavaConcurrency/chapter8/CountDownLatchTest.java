package chapter8;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownlatch：等待多线程完成的，允许一个或多个线程等待其他线程完成操作。
 * Created by yuanhao on 2017/5/10.
 */
public class CountDownLatchTest {

    static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                c.countDown();
                System.out.println(2);
                c.countDown();
            }
        }).start();
        c.await(); // 等待
        System.out.println("3");
    }

}
