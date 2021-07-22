package com.practise.algorithm;

/**
 * @Description 线性查找
 * @Author roman.gao
 * @Date 2021/6/27 3:06 下午
 */
public class LinearSearcher {

    /**
     * 1、关键字private：不能通过建立对象的方式来调用方法
     * 像 Math.random() 那样设计
     */
    private LinearSearcher() {
    }

    /**
     * 1、关键字：static：直接通过 LinearSearcher.search 来调用方法
     * 2、
     *
     * @param data
     * @param targetNum
     * @return
     */
    public static int search(int[] data, int targetNum) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == targetNum) {
                return i;
            }
        }
        return -1;
    }


}
