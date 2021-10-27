package com.practise.useProperties;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MainPro {
    public static void main(String[] args) {

        String[] split = "a".split("\\.");
        System.out.println(Arrays.toString(split));
        String tableName = Arrays.stream(split)
                .map(word -> "`" + word + "`")
                .collect(Collectors.joining("."));
        System.out.println(tableName);
    }
}
