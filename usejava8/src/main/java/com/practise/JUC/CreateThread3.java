package com.practise.JUC;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description 创建线程的三种方式
 * @Author lianggao
 * @Date 2021/11/16 上午11:38
 * @Version 1.0
 */
public class CreateThread3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建异步任务
        FutureTask<String> futureTask = new FutureTask<>(new CallerTask());
        new Thread(futureTask).start();
        String s = futureTask.get();
        System.out.println(s);
    }


}

/**
 * 可以继承其他类
 */
class CallerTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "hello thread";
    }
}
