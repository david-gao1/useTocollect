package com.practise.JUC;

/**
 * @Description TODO
 * @Author lianggao
 * @Date 2021/11/16 下午5:06
 * @Version 1.0
 */
public class WaitNotifyinterupt {
    static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("---begin--");
                    synchronized (object) {
                        object.wait();
                    }
                    System.out.println("--end--");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        Thread.sleep(1000);
        System.out.println("-- begin to interrupt ThreadA --");
        thread.interrupt();
        System.out.println("-- end interrupt ThreadA --");
    }
}
