package com.practise.useCollections;

import java.util.*;

public class UseCollecion {
    public static void main(String[] args) {

        //object->list
        final List<String> st = Arrays.asList("st");
        //新建的Collection不为null而是[].
        final Set<String> set = new HashSet<String>();
        System.out.println(set); //[]
        System.out.println(set.isEmpty()); //true
        final List<String> arrayListStrings = new ArrayList<>();
        System.out.println(arrayListStrings); //[]

        set.stream().forEach(System.out::println);//流为空时不会执行。

    }
}
