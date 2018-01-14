package chapter8;

import java.util.concurrent.CyclicBarrier;

/**
 * 同步屏障CyclicBarrier：可循环使用的屏障。让一组线程到达一个屏障（也可以叫同步点）时被阻塞，直到最后一个线程到达
 * 屏障时，屏障才会开门，所有屏障拦截的线程才会继续执行。
 * Created by yuanhao on 2017/5/10.
 */
public class CyclicBarrierTest {

    static CyclicBarrier c = new CyclicBarrier(2);

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                } catch (Exception e) {
                }
                System.out.println(1);
            }
        }).start();

        try {
            c.await();
        } catch (Exception e) {
        }
        System.out.println(2);

    }

}
