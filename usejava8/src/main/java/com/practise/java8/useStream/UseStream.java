package com.practise.java8.useStream;

import com.practise.java8.useStream.pojo.Trader;
import com.practise.java8.useStream.pojo.Transaction;

import java.util.*;
import java.util.stream.Collectors;

public class UseStream {

    public static void main(String[] args) {
        //useFlatMap();
        //1、
        List<Transaction> transactions = transactions();
        List<Transaction> transactions1 = transactions.stream()
                .filter(t -> Objects.equals(t.getYear(), 2011))
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println(transactions1);

        //2、
        List<String> cities = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());  //或者使用toSet，省略distinct。
        System.out.println(cities);


        //3、实现名字排序
        List<Transaction> transactionList = transactions.stream()
                .filter(transaction -> Objects.equals(transaction.getTrader().getCity(), "Cambridge")) //1、接受的传参接口，2、给抽象方法传实现并返回值
                /**
                 * 1、接收来自流的传参
                 * 2、参数类型的推断
                 * a、sort确定了比较的类型；->comparing推断出比较的类型；->Function传参类型的类型
                 * b、最后Function输出比较的字段
                 */
                .sorted(Comparator.comparing(x -> x.getTrader().getName()))
                .collect(Collectors.toList());
        System.out.println(transactionList);


        //3、实现名字排序
        List<Trader> traders1 = transactions.stream()
                .filter(transaction -> Objects.equals(transaction.getTrader().getCity(), "Cambridge"))  //可以先map
                .map(Transaction::getTrader)
                .sorted(Comparator.comparing(Trader::getName)) //排序可以放到distinct后面
                .distinct()
                .collect(Collectors.toList());
        System.out.println(traders1);

        //4、返回所有交易员的姓名字符串，按字母顺序排序
        final List<String> tradersWithNameSort = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .sorted()  //先去重再排序
                .distinct()
                .collect(Collectors.toList());
        System.out.println(tradersWithNameSort);

        //5、有没有交易员是在米兰工作的？
        final boolean milan = transactions.stream().anyMatch(transaction -> Objects.equals(transaction.getTrader().getCity(), "Milan"));

        //6、打印生活在剑桥的交易员的所有交易额。
        final Integer tradeValueInCambridge = transactions.stream()
                .filter(transaction -> Objects.equals(transaction.getTrader().getCity(), "Cambridge"))
                .map(Transaction::getValue)
                .reduce(0, Integer::sum);
        System.out.println("打印生活在剑桥的交易员的所有交易额:" + tradeValueInCambridge);

        //7、所有交易中，最高的交易额是多少
        final Integer maxTradeValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce(0, Integer::max);
        System.out.println("所有交易中，最高的交易额是多少:" + maxTradeValue);

        //8、找到交易额最小的交易。
        final Optional<Transaction> minTrade = transactions.stream()
                .sorted(Comparator.comparing(Transaction::getValue))
                .findFirst();
        minTrade.ifPresent(System.out::println); //cosumer直接打印了
        //8.2、使用聚合
        Optional<Transaction> minReduce = transactions.stream()
                .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
        //8.3、直接使用min
        final Optional<Transaction> min = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue));


    }

    public static List<Transaction> transactions() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        return transactions;
    }

    /**
     * 使用flatMap
     * flatMap:接收一个流，然后把所有（所有传递给flatMap中的流，同样对流可以做一些数据转换）的流连接起来形成一个新的流。
     */
    private static void useFlatMap() {
        Integer[] numArray1 = {1, 2, 3, 4, 5};
        Integer[] numArray2 = {4, 5};

        List<int[]> numPairList = Arrays.stream(numArray1)
                .flatMap(x -> Arrays.stream(numArray2)
                        .map(y -> new int[]{x, y})
                        .filter(pair -> (pair[0] + pair[1]) % 3 == 0))
                .collect(Collectors.toList());
        //打印字符对
        numPairList.stream().forEach(x -> System.out.println(Arrays.toString(x)));
    }

}