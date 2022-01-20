package com.practise.JUC.basic;

/**
 * @Description TODO
 * @Author lianggao
 * @Date 2021/11/18 上午10:54
 */
public class ThreadLocalMainThread {
    static ThreadLocal<String> localVariable = new ThreadLocal<>();

//    static ThreadLocal<String> localVariable = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        localVariable.set("hello threadLocal");

        new Thread(() -> System.out.println("threadOne:" + localVariable.get())).start();

        System.out.println("main: " + localVariable.get());
    }
}
