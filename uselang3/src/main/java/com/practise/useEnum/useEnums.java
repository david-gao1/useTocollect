package com.practise.useEnum;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

public class useEnums {
    public static final Logger LOG=LoggerFactory.getLogger(useEnums.class);

    public static void main(String[] args) {
//----------------------------------------------------------------------------------------------
        final ProjectClusterType hdfs = ProjectClusterType.valueOf("HDFS");//1、字符串转枚举
        System.out.println(hdfs.name());        //2、get名称
        System.out.println(hdfs.getValue());        //3、get value字段

    }
}
