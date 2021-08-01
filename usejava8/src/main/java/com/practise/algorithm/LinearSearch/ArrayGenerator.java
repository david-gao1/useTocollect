package com.practise.algorithm.LinearSearch;

import java.util.Random;

/**
 * 产生n个数据
 */
public class ArrayGenerator {

    private ArrayGenerator() {
    }

    /**
     * 按顺序产生数组元素
     *
     * @param n
     * @return
     */
    public static Integer[] generateOrderedArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    /**
     * 生成一个长度为 n 的随机数组，每个数字的范围是 [0, bound)
     *
     * @param n
     * @param bound
     * @return
     */
    public static Integer[] generateRandomArray(int n, int bound) {

        Integer[] arr = new Integer[n];
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rnd.nextInt(bound);
        }
        return arr;
    }
}