package com.practise.JUC.basic;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * @Description TODO
 * @Author lianggao
 * @Date 2021/11/16 下午5:51
 * @Version 1.0
 */
public class UseNotify {
    static volatile Object resourceA = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println("threadA get resourceA lock");
                    try {
                        System.out.println("threadA begin wait");
                        resourceA.wait();
                        System.out.println("theadA end wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println("threadB get resourceA lock");
                    try {
                        System.out.println("threadB begin wait");
                        resourceA.wait();
                        System.out.println("threadB end wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });


        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println("threadC begin notify");
                    //只有一个线程会被唤醒，另外一个线程一直处于堵塞状态，所以主流程一直不会结束
                    resourceA.notify();
                    //会唤醒所有的线程，抢到锁的线程执行完成之后，另外一个唤醒的线程获取锁继续执行，最后执行主流程
                    //resourceA.notifyAll();
                    //notifyAll只会唤醒之前调用过wait的线程
                }
            }
        });
        threadA.start();
        threadB.start();
        Thread.sleep(10);
        threadC.start();
        //wait thread stop
        threadA.join();
        threadB.join();
        threadC.join();
        System.out.println("main over");

    }
}
