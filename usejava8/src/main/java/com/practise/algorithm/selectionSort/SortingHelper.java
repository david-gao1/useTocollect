package com.practise.algorithm.selectionSort;

import com.practise.algorithm.LinearSearch.ArrayGenerator;

/**
 * @Description
 * @Author roman.gao
 * @Date 2021/8/1 6:16 下午
 */
public class SortingHelper {
    private SortingHelper() {
    }


    /**
     * 判断数组是否是有序的：
     * 后一个元素是否都比前一个元素大
     * <p>
     * 注意明确：Comparable
     * Raw use of parameterized class 'Comparable'
     *
     * @param arr
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> Boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i - 1]) < 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * 测试不同类型的算法
     *
     * @param className
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<E>> void testSelectionSort(String className, E[] arr) {

        long startTime = System.nanoTime();
        if ("SelectionSort".equals(className)) {
            SelectionSort.sort(arr);
        }
        if (!SortingHelper.isSorted(arr)) {
            throw new RuntimeException("SelectionSort is failed");
        }
        long endTime = System.nanoTime();
        System.out.printf("spend time is %f s%n", (endTime - startTime) / 1000000000.0);
    }
}
