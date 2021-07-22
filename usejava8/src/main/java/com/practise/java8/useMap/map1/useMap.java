package com.practise.java8.useMap.map1;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.*;

public class useMap {
    public static final Logger LOG = LoggerFactory.getLogger(useMap.class);

    public static void main(String[] args) {

    }

    public void getMap(){
        final Map<String, String> map = new HashMap<String, String>();
        map.put("1", "12");
        map.put("2", "12");
        map.put("3", "12");
        map.put("4", "12");
        Map<String, String> map1 = new HashMap<String, String>();
        //map1.putAll(map);                     //1、一个map“copy”到另一个
        map1 = map;
        System.out.println(map1.get("1"));
        System.out.println(map.size());   //输出map集合的大小
        System.out.println(map.keySet());  //输出所有的key值
        System.out.println(map.values());  //输出所有的value值
        System.out.println(map);   //输出所有的键值对。
        System.out.println(map.entrySet());  //输出所有的键值对。
    }

    public void traversalByEntry(Map<String, String> map) {
        //通过获取entryset,遍历key和value值
        StringBuilder appendMap = new StringBuilder();
        appendMap.append("[");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            appendMap.append("{key:").append(entry.getKey()).append(",")
                    .append("value:").append(entry.getValue()).append("} ");
        }
        appendMap.append("]");
        System.out.println(appendMap);
    }


    public void hashContain(String serverType) {
        //hashset的contains的使用，
        Set<String> validServerTypes = new HashSet<String>(Arrays.asList("hbase", "hippo", "mysql", "kafka"));
        if (!validServerTypes.contains(serverType)) {
            ///
        }
    }
}