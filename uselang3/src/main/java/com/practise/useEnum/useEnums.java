package com.practise.useEnum;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

public class useEnums {

    public static void main(String[] args) {
//----------------------------------------------------------------------------------------------
        final ProjectClusterType hdfs = ProjectClusterType.valueOf("HDFS");//1、字符串转枚举
        ProjectClusterType.HDFS.equals(hdfs.name());
        System.out.println(ProjectClusterType.HDFS.equals(ProjectClusterType.valueOf("HDFS")));
        System.out.println(ProjectClusterType.HDFS.name());        //2、get名称
        System.out.println(hdfs.getValue());        //3、get value字段
        System.out.println(ApproveInfoType.USER_REGISTRATION.name());

    }
}
