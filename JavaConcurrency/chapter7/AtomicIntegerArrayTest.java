package chapter7;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 *
 * Created by yuanhao on 2017/5/8.
 */
public class AtomicIntegerArrayTest {

    static int[] value = new int[] {1, 2};
    static AtomicIntegerArray ai = new AtomicIntegerArray(value);

    public static void main(String[] args) {
        ai.getAndSet(0, 3);
        System.out.println(ai.get(0));
        System.out.println(value[0]);
    }

}
