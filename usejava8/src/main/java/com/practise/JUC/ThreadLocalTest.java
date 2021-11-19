package com.practise.JUC;

/**
 * @Description TODO
 * @Author lianggao
 * @Date 2021/11/18 上午10:54
 */
public class ThreadLocalTest {

    static ThreadLocal<String> localVariable = new ThreadLocal<>();

    static void print(String str) {
        System.out.println(str + ":" + localVariable.get());
        //localVariable.remove();
    }


    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("threadOne local variable");
                print("threadOne");
                System.out.println("threadOne remove after" + ":" + localVariable.get());

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("threadTwo local variable");
                print("threadTwo");
                System.out.println("threadTwo remove after" + ":" + localVariable.get());

            }
        }).start();
    }
}
