package com.ml.lockSupport;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @NAME: LockSupportTest
 * @DATE: 2019/10/10
 * @Author Mr.MaL
 * @Description TODO
 **/
public class LockSupportTest3 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ": isInterrupted: " + Thread.currentThread().isInterrupted() + ": begin");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": isInterrupted: " + Thread.currentThread().isInterrupted() + ": start");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + ": isInterrupted: " + Thread.currentThread().isInterrupted() + ": end");
        });
        thread.start();
        TimeUnit.SECONDS.sleep(3);
        LockSupport.unpark(thread);
        System.out.println(Thread.currentThread().getName() + ": isInterrupted: " + Thread.currentThread().isInterrupted() + ": end");

    }

}
