package chapter5;

import java.util.concurrent.TimeUnit;

/**
 * Created by yuanhao on 2017/5/4.
 */
public class SleepUtils {

    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
