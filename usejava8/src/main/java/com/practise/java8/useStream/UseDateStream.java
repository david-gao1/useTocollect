package com.practise.java8.useStream;

import com.practise.java8.useStream.pojo.Transaction;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.practise.java8.useStream.UseStream.transactions;

public class UseDateStream {
    public static void main(String[] args) {
        IntStream intStream = getIntStream();
        useOptionalInt(intStream);
        useBox(intStream);
        useRange();
        int[] numbers = {2, 3, 5, 7, 11, 13};
        IntStream stream = Arrays.stream(numbers);
        OptionalInt max = stream.max();


    }


    /**
     * 1、转化为特化流
     *
     * @return
     */
    private static IntStream getIntStream() {
        List<Transaction> transactions = transactions();
        //1、转换为特化流（免除拆箱）
        return transactions.stream()
                .mapToInt(Transaction::getValue);
    }

    /**
     * //2、使用特化流
     *
     * @param intStream
     */
    private static void useOptionalInt(IntStream intStream) {

        OptionalInt max = intStream.max();   //sum,min,max,count,average

        //2.1、OptionalInt默认值的处理
        //OptionalInt返回值默认是0，但对于最大值来说这是不正确的结果。
        int maxValue = max.orElse(-1);
        System.out.println(maxValue);
    }

    /**
     * 3、转换为对象流
     * 注意：转换为对象流时，流一定时没有使用过的；
     * 像此时的操作就会报错：IllegalStateException: stream has already been operated upon or closed
     *
     * @param intStream
     */
    private static void useBox(IntStream intStream) {
        Stream<Integer> boxed = intStream.boxed();
    }


    /**
     * 产生数值范围，闭环
     * 使用range则左闭右开
     */
    private static void useRange() {
        IntStream.rangeClosed(1, 100)
                .filter(x -> x % 1 == 0)
                .forEach(System.out::println);
    }


}
