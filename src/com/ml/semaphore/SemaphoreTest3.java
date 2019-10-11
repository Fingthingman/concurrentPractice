package com.ml.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @NAME: SemaphoreTest1
 * @DATE: 2019/10/11
 * @Author Mr.MaL
 * @Description TODO
 **/
public class SemaphoreTest3 {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(2);

        Thread t1 = new Thread(() -> {
            Boolean result = Boolean.FALSE;
            try {
                System.out.println(Thread.currentThread().getName() + ": start");
                semaphore.acquire();
                result = Boolean.TRUE;
                System.out.println(Thread.currentThread().getName() + ": doing");
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + ": end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if(result){
                semaphore.release();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            Boolean result = Boolean.FALSE;
            try {
                System.out.println(Thread.currentThread().getName() + ": start");
                semaphore.acquire();
                result = Boolean.TRUE;
                System.out.println(Thread.currentThread().getName() + ": doing");
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + ": end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (result) {
                    semaphore.release();
                }

            }
        });

        Thread t3 = new Thread(() -> {
            Boolean result = Boolean.FALSE;
            try {
                System.out.println(Thread.currentThread().getName() + ": start");
                semaphore.acquire();
                result = Boolean.TRUE;
                System.out.println(Thread.currentThread().getName() + ": doing");
                System.out.println(Thread.currentThread().getName() + ": end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (result) {
                    semaphore.release();
                }
                System.out.println(semaphore.availablePermits());
            }
        });

        t1.start();
        t2.start();
        t3.start();

        TimeUnit.SECONDS.sleep(1);
        System.out.println(semaphore.availablePermits());
        t3.interrupt();
        t1.join();
        t2.join();
        t3.join();


    }
}
