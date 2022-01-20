package com.practise.JUC.basic2;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * @Description TODO
 * @Author lianggao
 * @Date 2021/11/25 上午9:58
 * @Version 1.0
 */
public class ReadThread extends Thread {

    private static int num = 0;
    private static boolean ready = false;


    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            if (ready) {  //1
                System.out.println(num + num);  //2
            }
            System.out.println("read thread...");
        }
    }

    public static class Writethread extends Thread {
        @Override
        public void run() {
            //3，4指令重排 即num还有没有赋值 代码2就执行到值结果是0
            num = 2;        //3
            ready = true;   //4
            System.out.println("write thread set over...");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ReadThread readThread = new ReadThread();
        readThread.start();

        Writethread writethread = new Writethread();
        writethread.start();

        Thread.sleep(10);
        readThread.interrupt();
        System.out.println("main exit");
    }
}
