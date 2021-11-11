package com.practise.JUC;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

//fork/join任务类
class MyTask extends RecursiveTask<Integer> {

    //子任务阈值：拆分差值不能超过10，计算10以内运算
    private static final Integer VALUE = 10;
    private int begin; //拆分开始值
    private int end; //拆分结束值
    private int result; //返回结果

    public MyTask(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    /**
     * 拆分和合并过程
     * @return
     */
    @Override
    protected Integer compute() {
        if ((end - begin) <= VALUE) { //小于阈值就计算任务
            for (int i = begin; i <= end; i++) {
                result = result + i;
            }
        } else {//任务大于阈值：分裂成两个子任务进行计算
            int middle = (begin + end) / 2;
            MyTask task01 = new MyTask(begin, middle);
            MyTask task02 = new MyTask(middle + 1, end);
            task01.fork();//拆分：执行子任务
            task02.fork();
            //合并结果
            result = task01.join() + task02.join();
        }
        return result;
    }
}

public class ForkJoinDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyTask myTask = new MyTask(0, 100);
        //创建分支合并池对象
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(myTask);
        //获取最终合并之后结果
        Integer result = forkJoinTask.get();
        System.out.println(result);
        //关闭池对象
        forkJoinPool.shutdown();
    }
}
