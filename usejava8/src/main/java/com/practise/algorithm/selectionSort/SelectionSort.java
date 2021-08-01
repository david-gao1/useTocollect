package com.practise.algorithm.selectionSort;

/**
 * 选择排序：
 * 1、
 *
 * @Author roman.gao
 * @Date 2021/7/28 11:51 下午
 */
public class SelectionSort {
    /**
     * 工具类：禁止创建对象
     */
    private SelectionSort() {
    }

    /**
     * 1、找出当前数组中最小的元素：当前循环元素和它之后所有的元素进行比较
     * 2、swap：当前循环元素和最小元素位置替换
     * 3、指针向下继续循环
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        //循环不变量：arr[0....i) 是有序的；arr[i...0)是无序的
        for (int i = 0; i < arr.length; i++) {
            int minNumIndex = i;
            //最小元素思路：始终是当前最小的元素和循环的下一个元素进行比较
            for (int j = i; j < arr.length; j++) {
                if (arr[minNumIndex] > arr[j]) {
                    minNumIndex = j;
                }
            }
            swap(arr, i, minNumIndex);
        }
    }

    /**
     * 元素替换：通过一个临时变量进行元素变换
     *
     * @param arr
     * @param i
     * @param minNumIndex
     */
    private static void swap(int[] arr, int i, int minNumIndex) {
        int tmpNum = arr[i];
        arr[i] = arr[minNumIndex];
        arr[minNumIndex] = tmpNum;
    }

}
