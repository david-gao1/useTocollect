package com.practise.useStr;

import com.practise.useMap.Constants;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserStr {
    private static final String SPECIAL_WORD_REG_EX = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";


    public static void main(String[] args) {
        //字符串是包含""的
        checkContains();
        //checkSplit();
        String keyword = "";
        convertSpecialWord(keyword);
    }


    /**
     * 1、查看字符串中是否包含""。
     */
    private static void checkContains() {
        final String test = "test";
        System.out.println(test.contains("")); //true;
    }

    /**
     * 2、对于split分割数组的讨论
     */
    private static void checkSplit() {
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
     * 3、特殊字符转换为sql可以查询的字符
     *
     * @param keyword
     * @return
     */
    private static String convertSpecialWord(String keyword) {
        Pattern compile = Pattern.compile(SPECIAL_WORD_REG_EX);
        String escName = Arrays.stream(keyword.split(""))
                .map(t -> {
                    t = compile.matcher(t).find() ? "\\" + t : t;
                    return t;
                })
                .collect(Collectors.joining());
        return escName;
    }
}