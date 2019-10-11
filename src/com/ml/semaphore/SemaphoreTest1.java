package com.ml.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @NAME: SemaphoreTest1
 * @DATE: 2019/10/11
 * @Author Mr.MaL
 * @Description TODO
 **/
public class SemaphoreTest1 {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(2);

       Thread t1 = new Thread(()->{
           try {
               System.out.println(Thread.currentThread().getName()+": start");
               semaphore.acquire();
               System.out.println(Thread.currentThread().getName()+": doing");
               TimeUnit.SECONDS.sleep(3);
               System.out.println(Thread.currentThread().getName()+": end");
           } catch (InterruptedException e) {
               e.printStackTrace();
           }finally {
               semaphore.release();
           }
       });

        Thread t2 = new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+": start");
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName()+": doing");
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+": end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
            }
        });

        Thread t3 = new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+": start");
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName()+": doing");
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+": end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
            }
        });

        t1.start();
        t2.start();
        t3.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(semaphore.availablePermits());
        System.out.println(semaphore.isFair());
        t1.join();
        t2.join();
        t3.join();


    }
}
