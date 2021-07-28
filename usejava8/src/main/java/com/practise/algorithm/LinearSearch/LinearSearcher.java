package com.practise.algorithm.LinearSearch;

/**
 * @Description 线性查找:找到符合要求的元素位置
 * @Author roman.gao
 * @Date 2021/6/27 3:06 下午
 */
public class LinearSearcher {

    /**
     * 1、关键字private：不希望用户建立对象的方式来调用方法
     * 像 Math.random() 那样设计
     */
    private LinearSearcher() {
    }

    /**
     * 1、关键字：static：直接通过 LinearSearcher.search 来调用方法
     * 2、使用泛型让 工具类更加通用：
     * equals方法： 泛型指的是除基本数据类型之外的类型，每个类型都有自己实现的equals方法
     *
     * @param data
     * @param targetNum
     * @return
     */
    public static <T> int search(T[] data, T targetNum) {
        for (int i = 0; i < data.length; i++) {
            //== 是引用对比；使用equals是值对比
            //这是泛型T实现的equals方法
            if (data[i].equals(targetNum)) {
                return i;
            }
        }
        return -1;
    }


}
