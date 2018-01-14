package chapter7;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * Created by yuanhao on 2017/5/8.
 */
public class AtomicIntegerTest {

    static AtomicInteger ai  = new AtomicInteger(1);

    public static void main(String[] args) {
        System.out.println(ai.getAndIncrement());
        System.out.println(ai.get());
    }

}
