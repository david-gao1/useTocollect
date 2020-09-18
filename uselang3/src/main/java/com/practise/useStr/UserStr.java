package com.practise.useStr;

import com.practise.useMap.Constants;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UserStr {

    public static void main(String[] args) {
        //字符串是包含""的
        final String test = "test";
        System.out.println(test.contains("")); //true;


        //测试截取
        /**
         * 长度是5，因为从开始判断分割，如果第一位符合分隔表达式则第一位存储位空，
         * 依次类推直到不符合分隔表达式
         */
        String remotePath = "/ftp/gao/all/test/";
        System.out.println(remotePath.split("/").length);//5

        String remotePath1 = "ftp/gao/all/test/";
        System.out.println(remotePath1.split("/").length);//4


        /**
         * 遍历数组
         */
        final String[] split = remotePath.split("/");
        Arrays.stream(split).forEach(System.out::println);

    }
}
