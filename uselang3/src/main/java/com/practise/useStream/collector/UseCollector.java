package com.practise.useStream.collector;

import com.practise.useStream.UseStream;
import com.practise.useStream.pojo.Trader;
import com.practise.useStream.pojo.Transaction;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UseCollector {
    public static void main(String[] args) {
        //计算count
        List<Transaction> transactions = UseStream.transactions();
        long transactionQuantity = transactions.stream().count(); //collect(Collectors.counting())->count()
        long count = transactions.size();   //transactions.stream().count()->transactions.size()
        //        final Optional<Transaction> collect = transactions.stream()
        //                .collect(Collectors.maxBy(Comparator.comparing(Transaction::getValue)));
        Optional<Transaction> collect = transactions.stream()
                .max(Comparator.comparing(Transaction::getValue));
        Integer sum = transactions.stream()
                .mapToInt(Transaction::getValue).sum();  //collect(Collectors.summingInt(Transaction::getValue))
        IntSummaryStatistics collect1 = transactions.stream()
                .collect(Collectors.summarizingInt(Transaction::getValue));
        String nameWithJoining = transactions.stream()
                .map(t -> t.getTrader().getName())
                .collect(Collectors.joining(","));
        System.out.println(collect1);


        //按照年进行分组：得到的是一个map：key=年份，value是一个这个年份所有的交易
        Map<Integer, List<Transaction>> collect2 = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getYear));

        //按照交易额的范围进行分组：按照返回的进行分组。
        Map<String, List<Transaction>> collect3 = transactions.stream()
                .collect(Collectors.groupingBy(t -> {
                    if (t.getValue() < 500) {
                        return "少交易额";
                    } else if (t.getValue() >= 500 && t.getValue() < 1000) {
                        return "多交易额";
                    } else {
                        return "其他交易额";
                    }
                }));
        Set<Map.Entry<String, List<Transaction>>> entries = collect3.entrySet();
        for (Map.Entry<String, List<Transaction>> entry : entries) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        //进行多级分组:每年每个交易员的分组情况
        Map<Integer, Map<Trader, List<Transaction>>> collect4 = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getYear,
                        Collectors.groupingBy(Transaction::getTrader)));

        //将收集器的结果转为其他类型：
        //1、计算每一年的交易量有多少
        Map<Integer, Long> collect5 = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getYear, Collectors.counting()));
        System.out.println(collect5);  //map可以直接输出：{2011=2, 2012=4}

        //2、计算每年最大的交易量
        Map<Integer, Transaction> collect6 = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getYear,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Transaction::getValue)), Optional::get)));
        System.out.println(collect6);  //map可以直接输出：{2011=2, 2012=4}


    }


}
