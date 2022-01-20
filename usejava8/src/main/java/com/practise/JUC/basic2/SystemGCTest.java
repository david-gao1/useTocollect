package com.practise.JUC.basic2;

public class SystemGCTest {
    public static void main(String[] args) {
        new SystemGCTest();
        System.gc();// 提醒JVM的垃圾回收器执行gc，但是不确定是否马上执行gc
        // 与Runtime.getRuntime().gc();的作用一样
        
        System.runFinalization();//强制执行使用引用的对象的finalize()方法
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("SystemGCTest 重写了finalize()");
    }
}