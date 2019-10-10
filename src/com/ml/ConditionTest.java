package com.ml;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @NAME: ConditionTest
 * @DATE: 2019/10/10
 * @Author Mr.MaL
 * @Description TODO
 **/
public class ConditionTest {

    static ReentrantLock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static class Thread1 extends Thread{
        @Override
        public void run() {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"获取锁");
                condition.await();
                System.out.println(Thread.currentThread().getName()+"重新获取锁");
                TimeUnit.MINUTES.sleep(1);
                System.out.println(Thread.currentThread().getName()+"释放锁");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }

    public static class Thread2 extends Thread{
        @Override
        public void run() {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"获取锁");
                condition.signal();
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName()+"释放锁");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread1().start();
        TimeUnit.SECONDS.sleep(1);
        new Thread2().start();
    }


}
