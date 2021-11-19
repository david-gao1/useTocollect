package com.practise.JUC;


/**
 * @Description TODO
 * @Author lianggao
 * @Date 2021/11/16 下午7:26
 * @Version 1.0
 */
public class UseInterrupt {
    public static void main(String[] args) throws InterruptedException {
        //setInterrupt();
        toActiveThreadByInterrupt();
    }

    private static void toActiveThreadByInterrupt() throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("threadA begin sleep for 2000 s");
                    Thread.sleep(2000000);
                    System.out.println("threadA awaking");
                } catch (InterruptedException e) {
                    System.out.println("threadA is interrupted while sleeping");
                    return;
                }
                System.out.println("threadA-leaving normally");
            }
        });
        //启动子线程
        threadA.start();
        //主线程休眠，以便中断前让子线程输出
        Thread.sleep(1000);
        //中断子线程
        System.out.println("main thread interrupt thread");
        threadA.interrupt();

        //等待子线程执行完毕
        threadA.join();
        System.out.println("main is over");
    }

    private static void setInterrupt() throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread() + " hello");
                }
            }
        });
        //启动子线程
        threadA.start();
        //主线程休眠，以便中断前让子线程输出
        Thread.sleep(1000);
        //中断子线程
        System.out.println("main thread interrupt thread");
        threadA.interrupt(); //设置中断标志为true

        //等待子线程执行完毕
        threadA.join();
        System.out.println("main is over");
    }
}
