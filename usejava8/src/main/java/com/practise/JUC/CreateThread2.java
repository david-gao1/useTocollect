package com.practise.JUC;

/**
 * @Description 创建线程的三种方式
 * @Author lianggao
 * @Date 2021/11/16 上午11:38
 * @Version 1.0
 */
public class CreateThread2 {
    public static void main(String[] args) {
        //创建线程
        RunnableTask runnableTask = new RunnableTask();
        /**
         * 1、两个线程公用一个代码逻辑
         * 2、如果有需要可以给不同的线程创建名字
         * 3、但是方法没有返回值
         */
        new Thread(runnableTask, "t1").start();
        new Thread(runnableTask, "t2").start();

    }
}

/**
 * 可以继承其他类
 */
class RunnableTask implements Runnable {
    @Override
    public void run() {
        System.out.println("second way to make thread runing");
    }
}
