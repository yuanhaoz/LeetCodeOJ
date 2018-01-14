package chapter8;

import java.util.concurrent.CyclicBarrier;

/**
 * CountDownLatch的计数器只能使用一次，而CyclicBarrier的计数器可以使用reset()方法重置。
 * CyclicBarrier还提供其他有用的方法，如getNumberWaiting方法可以获取CyclicBarrier阻塞的线程数量。
 * isBroken()方法用来了解阻塞的线程是否被中断。
 *
 * Created by yuanhao on 2017/5/10.
 */
public class CyclicBarrierTest3 {

    static CyclicBarrier c = new CyclicBarrier(2);

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                } catch (Exception e) {

                }
            }
        });
        thread.start();
        thread.interrupt();
        try {
            c.await();
        } catch (Exception e) {
            System.out.println(c.isBroken());
        }
    }



}
