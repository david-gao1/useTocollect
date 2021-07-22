package com.practise.java8.useinterface.functioninterface;


import java.util.function.Consumer;

public class Demo01Consumer {

    public static void main(String[] args) {
        method1("赵丽颖", System.out::println);
        method2("123abC"
                , s -> System.out.println(s.toLowerCase())
                , s -> System.out.println(s.toUpperCase()));
    }

    /**
     * 1、消费（按照lambda的逻辑进行消费）一个字符串数据
     * 没有返回值
     *
     * @param name 消费的数据
     * @param con  consumer实例，String:决定消费的类型是字符串
     */
    public static void method1(String name, Consumer<String> con) {
        con.accept(name);
    }

    /**
     * 2、重复消费给定数据
     *
     * @param s    消费的数据
     * @param con1
     * @param con2
     */
    public static void method2(String s, Consumer<String> con1, Consumer<String> con2) {
        con1.andThen(con2).accept(s);//后执行con2消费数据
    }

}