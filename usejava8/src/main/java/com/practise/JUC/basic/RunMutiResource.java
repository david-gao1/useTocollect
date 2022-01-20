package com.practise.JUC.basic;

/**
 * 需要注意的是，当前线程调用共享变量的 wait()方法后只会释放当前共享变量上的锁，
 * 如果线程还持有其他共享变量的锁，则这些锁是不会被释放
 * 如下代码：线程B一直获取不了资源B的锁，处于堵塞状态
 *
 * @Author lianggao
 * @Date 2021/11/16 下午4:48
 */
public class RunMutiResource {
    //创建资源
    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println("threadA get resourceA lock");
                    synchronized (resourceB) {
                        System.out.println("threadA get resourceB lock");

                        System.out.println("threadA release resourceA lock");
                        try {
                            resourceA.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        //另外需要注意的是，当前线程调用共享变量的 wait()方法后只会释放当前共享变量上
        //的锁，如果 线程还持有其他共享变量的锁，则这些锁是不会被释放
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    synchronized (resourceA) {
                        System.out.println("threadB get resourceA lock");

                        System.out.println("threadB try to get resourceB lock");
                        synchronized (resourceB) {
                            System.out.println("threadB get resourceB lock");

                            System.out.println("threadB release resourceA lock");
                            resourceA.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        // 启动线程
        threadA.start();
        threadB.start();
        //等待两个线程结束
        threadA.join();
        threadB.join();
        System.out.println("main over");

    }
}
