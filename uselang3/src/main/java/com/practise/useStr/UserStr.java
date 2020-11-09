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
        UseStrings.checkContains();
        //checkSplit();
        String keyWord = UseStrings.convertSpecialWord("hello_world");
    }


}