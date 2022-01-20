package com.practise.JUC.basic;

/**
 * @Description 创建线程的三种方式
 * @Author lianggao
 * @Date 2021/11/16 上午11:38
 * @Version 1.0
 */
public class CreateThread {
    public static void main(String[] args) {
        //创建线程
        MyThread myThread = new MyThread();
        /**
         * 启动线程
         * 调用start方法并没有马上执行而是处于就绪状态（指该线程已经获取除cpu外的其他资源），
         * 等待获取cpu资源后才会真正处于运行状态
         * 一旦run方法执行完毕该线程就处于终止状态
         */
        myThread.start();
    }
}

/**
 * 使用继承方式的好处:
 * 在run()方法内获取当前线程直接使用this就可以了，无
 * 使用Thread. currentThread（）方法
 *
 * 不好的地方:
 * Java 不支持多继承，如果继承了 thread 类，那么就不能再继承其他类。
 * 另外任务与代码没有分离 当多个线程执行一样的任务时需要多份任务代码
 */
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("first way to make thread runing");
    }
}
