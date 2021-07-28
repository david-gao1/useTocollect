package com.practise.algorithm.LinearSearch;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;


/**
 * @Description 线性查找 泛型 实现equals
 * @Author roman.gao
 * @Date 2021/7/27 10:29 下午
 */
public class MainRun {

    public static void main(String[] args) {
        //泛型的线性查找
        SearchStu();
        //测试程序的性能
        testPerformance();
    }

    /**
     * 测试线性查找性能
     * //1、产生一定规模的数据
     * //2、循环100次执行，测试程序的稳定性
     * //3、观察测试的时间
     */
    private static void testPerformance() {
        int[] dataSizeArray = {1000000, 10000000}; //测试不同规模的数据，是否大致符合O(n)
        for (int i : dataSizeArray) {
            Integer[] testDatas = ArrayGenerator.generateOrderedArray(i);
            long startTime = System.nanoTime();
            for (int k = 0; k < 100; k++) {
                LinearSearcher.search(testDatas, i); //查找最后一个查找不到的数，不关心结果，关心执行时间
            }
            long endTime = System.nanoTime();
            double spendTime = (endTime - startTime) / 1000000000.0;
            System.out.println("scale is " + i + ",running 100 times spend " + spendTime + " s");
        }
    }

    /**
     * 查找目标自定义类
     */
    private static void SearchStu() {
        Student[] students = {new Student("Alice"),
                new Student("Bobo"),
                new Student("Chalrles")};
        int boboIndex = LinearSearcher.search(students, new Student("Bobo"));
        System.out.println("get students postion is " + boboIndex + 1);
    }


}
