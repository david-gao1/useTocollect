package com.practise.java8.useinterface.functioninterface;

import java.util.Arrays;
import java.util.function.Supplier;


public class Demo01Supplier {

    public static void main(String[] args) {
        int[] num = {14, 6, 5, 9};
        int maxNum = getString(() -> {
            Arrays.sort(num);
            return num[num.length - 1];
        });
        System.out.println(maxNum);
    }

    /**
     * 生产型接口
     *
     * @param sup 生产出Integer数据
     * @return
     */
    public static Integer getString(Supplier<Integer> sup) {
        return sup.get();
        // 不要被sup.get()所迷惑，你试试return "hello world",也是可以的，不过我们要想拿到生产型接口的返回值，自然而然就是sup.get（）了。
    }
}
