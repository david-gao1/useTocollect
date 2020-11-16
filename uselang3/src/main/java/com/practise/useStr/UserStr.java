package com.practise.useStr;

public class UserStr {
    private static final String SPECIAL_WORD_REG_EX = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";


    public static void main(String[] args) {
        //字符串是包含""的
        UseStrings.checkContains();
        //checkSplit();
        String keyWord = UseStrings.convertSpecialWord("hello_world");
    }


}