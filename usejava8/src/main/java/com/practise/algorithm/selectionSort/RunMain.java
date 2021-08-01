package com.practise.algorithm.selectionSort;

import com.practise.algorithm.LinearSearch.ArrayGenerator;
import com.practise.algorithm.LinearSearch.Student;

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


        Student[] students = {new Student("Alice", 98),
                new Student("Bobo", 100),
                new Student("Charles", 66)};
        SelectionSort.sort(students);
        System.out.println(Arrays.toString(students));

        int[] scales = {10000, 100000};
        for (int scale : scales) {
            Integer[] randNums = ArrayGenerator.generateRandomArray(scale, scale);
            SortingHelper.testSelectionSort("SelectionSort", randNums);
        }
    }
}
