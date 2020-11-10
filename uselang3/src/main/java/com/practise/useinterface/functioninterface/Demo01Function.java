package com.practise.useinterface.functioninterface;

import java.util.function.Function;

public class Demo01Function {

    public static void main(String[] args) {
        String s = "1234";
        //1、字符转为Integer
        final Integer change = change1(s, str -> Integer.valueOf(str));
        //2、转换字符为integer，数字加10.再转为字符
        final String s2 = change2(s
                , str -> Integer.valueOf(str)
                , num -> {
                    Integer num1 = num + 10;
                    final String s1 = String.valueOf(num1);
                    return s1;
                });
        System.out.println(s2);
    }


    /**
     * 1、使用apply：参数类型转换
     *
     * @param s   待转换的参数数据
     * @param fun Function<String, Integer>：string->Integer
     */
    public static Integer change1(String s, Function<String, Integer> fun) {
        Integer apply = fun.apply(s);
        return apply;
    }

    /**
     * 2、使用andThen + apply 进行两次类型转换
     *
     * @param s    待转换的字符串
     * @param fun1 String —> Integer  返回function接口实例（带有代码块的，即通过lambda实例化）
     * @param fun2 Integer -> String  返回字符串
     * @return
     */
    public static String change2(String s, Function<String, Integer> fun1, Function<Integer, String> fun2) {
        String ss = fun1.andThen(fun2).apply(s);
        return ss;
    }

}