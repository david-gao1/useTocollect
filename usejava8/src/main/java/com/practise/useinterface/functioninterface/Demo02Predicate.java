package com.practise.useinterface.functioninterface;

import java.util.function.Predicate;


public class Demo02Predicate {

    public static void main(String[] args) {
        String s = "abcdef";
        boolean b1 = checkString(s, str -> str.length() > 5);
        System.out.println(b1);
        boolean b2 = checkString2(s
                , str -> str.length() > 5
                , str -> str.contains("a"));
        System.out.print(b2);
    }

    /**
     * 1、使用test抽象方法
     * 传递一个函数式接口的实现（通过传递lambda的方式），lambda代码块指出判断的逻辑
     *
     * @param s
     * @param pre1
     * @return
     */
    public static boolean checkString(String s, Predicate<String> pre1) {
        return pre1.test(s);
    }


    /**
     * 2、使用and默认方法和test抽象方法
     * 传递两个函数式接口的实现（通过传递lambda的方式），进行两次逻辑判断
     * 3、还有or和 4、negate（取反）使用类似
     *
     * @param s
     * @param pre1
     * @param pre2
     * @return
     */
    public static boolean checkString2(String s, Predicate<String> pre1, Predicate<String> pre2) {
        /**
         * and():第一次判断，返回Predicate接口
         * test():第二次判断，返回boolean值，得出结果
         */
        return pre1.and(pre2).test(s);//等价于return pre1.test(s) && pre2.test(s);
    }

}