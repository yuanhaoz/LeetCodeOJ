package chapter8;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Exchanger用于线程间合作。它提供一个同步点，在这个同步点，两个线程可以交换彼此的数据。
 * 当两个线程都到达同步点时，这两个线程就可以交换数据，将本线程生产出来的数据传递给对方。
 * Created by yuanhao on 2017/5/10.
 */
public class ExchangerTest {

    private static final Exchanger<String> exgr = new Exchanger<>();

    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String A = "银行流水A";    // A录入银行流水数据
                    exgr.exchange(A);
                } catch (Exception e) {

                }
            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String B = "银行流水B";    // B录入银行流水数据
                    String A = exgr.exchange("B");
                    System.out.println("A和B数据是否一致：" + A.equals(B) + ",A录入的是：" + A + ",B录入的是：" + B);
                } catch (Exception e) {

                }
            }
        });
        threadPool.shutdown();
    }

}
