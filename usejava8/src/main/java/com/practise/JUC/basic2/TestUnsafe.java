package com.practise.JUC.basic2;


import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Description cas的使用案例
 * @Author lianggao
 * @Date 2021/11/19 上午11:34
 */
public class TestUnsafe {
    static final Unsafe unsafe;
    static final long stateOffset;
    private volatile long state = 0;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
            //返回指定变量所在类中的内存偏移地址
            //该地址仅在改Unsafe函数中访问指定字段时使用
            stateOffset = unsafe.objectFieldOffset(TestUnsafe.class.getDeclaredField("state"));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }


    public static void main(String[] args) {
        TestUnsafe testUnsafe = new TestUnsafe();
        boolean isSucess = unsafe.compareAndSwapInt(
                testUnsafe,  //对象内存位置
                stateOffset, //对象中变量的偏移量
                0,        //变量预期值
                1);      //新的值
        System.out.println(isSucess);
    }
}
