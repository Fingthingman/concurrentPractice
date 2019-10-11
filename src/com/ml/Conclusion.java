package com.ml;

/**
 * @NAME: Conclusion
 * @DATE: 2019/10/10
 * @Author Mr.MaL
 * @Description TODO
 **/
public class Conclusion {

    /**
     * LockSupport类可以阻塞当前线程以及唤醒指定被阻塞的线程。
     * 主要是通过park()和unpark(thread)方法来实现阻塞和唤醒线程的操作的。
     *
     *
     * 每个线程都有一个许可(permit)，permit只有两个值1和0，默认是0。
     * 当调用unpark(thread)方法，就会将thread线程的许可permit设置成1(注意多次调用unpark方法，不会累加，permit值还是1)。
     * 当调用park()方法，如果当前线程的permit是1，那么将permit设置为0，并立即返回。如果当前线程的permit是0，那么当前线程就会阻塞，直到别的线程将当前线程的permit设置为1时，park方法会被唤醒，然后会将permit再次设置为0，并返回。
     * 注意：因为permit默认是0，所以一开始调用park()方法，线程必定会被阻塞。调用unpark(thread)方法后，会自动唤醒thread线程，即park方法立即返回。
     */

    /**
     * 常用方法
     * void park()：阻塞当前线程，如果调用unpark方法或者当前线程被中断，从能从park()方法中返回
     *
     * void park(Object blocker)：功能同方法1，入参增加一个Object对象，用来记录导致线程阻塞的阻塞对象，方便进行问题排查
     *
     * void parkNanos(long nanos)：阻塞当前线程，最长不超过nanos纳秒，增加了超时返回的特性
     *
     * void parkNanos(Object blocker, long nanos)：功能同方法3，入参增加一个Object对象，用来记录导致线程阻塞的阻塞对象，方便进行问题排查
     *
     * void parkUntil(long deadline)：阻塞当前线程，直到deadline，deadline是一个绝对时间，表示某个时间的毫秒格式
     *
     * void parkUntil(Object blocker, long deadline)：功能同方法5，入参增加一个Object对象，用来记录导致线程阻塞的阻塞对象，方便进行问题排查；
     */

    /**
     * 线程等待和唤醒的3种方式做个对比
     *
     * 方式1：Object中的wait、notify、notifyAll方法
     * 方式2：juc中Condition接口提供的await、signal、signalAll方法
     * 方式3：juc中的LockSupport提供的park、unpark方法
     *
     * 3种方式对比：
     *                                   Object	                    Condtion	                LockSupport
     * 前置条件	                    需要在synchronized中运行	需要先获取Lock的锁	                无
     * 无限等待	                         支持	                    支持	                        支持
     * 超时等待	                         支持	                    支持	                        支持
     * 等待到将来某个时间返回	        不支持	                    支持	                        支持
     * 等待状态中释放锁	                会释放	                    会释放	                        不会释放
     * 唤醒方法先于等待方法执行           否	                      否	                        可以
     * ，能否唤醒线程
     * 是否能响应线程中断	              是	                      是	                        是
     * 线程中断是否会清除中断标志	      是	                      是	                        否
     * 是否支持等待状态中不响应中断	    不支持	                    支持	                        不支持
     */

}
