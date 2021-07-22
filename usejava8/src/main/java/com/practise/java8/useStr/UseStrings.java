package com.practise.java8.useStr;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UseStrings {
    private static final String SPECIAL_WORD_REG_EX = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";

    /**
     * 1、特殊字符转换为sql可以查询的字符
     *
     * @param keyword
     * @return
     */
    public static String convertSpecialWord(String keyword) {
        Pattern compile = Pattern.compile(SPECIAL_WORD_REG_EX);
        String escName = Arrays.stream(keyword.split(""))
                .map(t -> {
                    t = compile.matcher(t).find() ? "\\" + t : t;
                    return t;
                }).skip(1)
                .collect(Collectors.joining());
        return escName;
    }

    /**
     * 2、对于split分割数组的讨论
     */
    public static void checkSplit() {
        /**
         * a、split后数组长度的确定
         * 长度是5，因为从开始判断分割，如果第一位符合分隔表达式则第一位存储位空，
         * 最后有没有“/”不影响长度的计算。
         * 依次类推直到不符合分隔表达式
         */
        String remotePath = "/ftp/gao/all/test/";
        System.out.println(remotePath.split("/").length);//5

        String remotePath1 = "ftp/gao/all/test";
        System.out.println(remotePath1.split("/").length);//4

        /**
         * b、spilt后遍历数组元素
         */
        final String[] split = remotePath.split("/");
        Arrays.stream(split).forEach(System.out::println);//第一个元素，“空”也打出来了
    }


    /**
     * 3、查看字符串中是否包含""。
     */
    public static void checkContains() {
        final String test = "test";
        System.out.println(test.contains("")); //true;
    }

    /**
     * 4、使用Objects.equals：避免了空指针的判断，但是要注意判断时，两个比较的实例是同一类对象，比如Integer 和Short就不一样。
     */
    public static void useEquals(){
        //反过来写equals，或者用Objects.equals去比较
        String var1 = "strTest1";
        String va2 = "strTest2";
        System.out.print(Objects.equals(null,null));
    }

}
