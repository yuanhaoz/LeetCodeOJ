package chapter5;

import niuke.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * Created by yuanhao on 2017/5/4.
 */
public class TwinsLockTest {

    public static void main(String[] args) {
        TwinsLockTest twinsLockTest = new TwinsLockTest();
        twinsLockTest.test();
    }

   public void test() {
       final Lock lock = new TwinsLock();
       class Worker extends Thread {
           public void run() {
               while (true) {
                   lock.lock();
                   try {
                       SleepUtils.second(1);
                       System.out.println(Thread.currentThread().getName());
                       SleepUtils.second(1);
                   } finally {
                       lock.unlock();
                   }
               }
           }
       }
       // 启动10个线程
       for (int i = 0; i < 10; i++) {
           Worker w = new Worker();
           w.setDaemon(true);
           w.start();
       }
       // 每个一秒换行
       for (int i = 0; i < 10; i++) {
           SleepUtils.second(1);
           System.out.println();
       }
//       ReentrantReadWriteLock
//       ReentrantLock
//       Condition
   }

}
