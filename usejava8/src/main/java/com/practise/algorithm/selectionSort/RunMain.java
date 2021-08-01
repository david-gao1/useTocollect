package com.practise.algorithm.selectionSort;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author roman.gao
 * @Date 2021/8/1 12:05 下午
 */
public class RunMain {
    public static void main(String[] args) {
        Integer[] arr = {888, 111, 2, 444, 6, 888, 999};
        SelectionSort.sort(arr);
        System.out.print(Arrays.toString(arr));

    }
}
