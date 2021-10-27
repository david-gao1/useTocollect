package com.practise.designpattern.iterator;

import java.util.Iterator;
import java.util.List;

import static java.lang.System.*;

/**
 * 调用遍历器统一输出所有学院的系
 */
public class OutPutImpl {
    List<College> collegeList;

    public OutPutImpl(List<College> collegeList) {
        this.collegeList = collegeList;
    }

    public void printCollege() {
        Iterator<College> iterator = collegeList.iterator();//1、*****list本身就有遍历能力
        while (iterator.hasNext()) {
            College college = iterator.next();
            printDepartment(college.createIterator());//2、*****遍历具有遍历能力的学院
        }
    }

    public void printDepartment(Iterator iterator) {
        while (iterator.hasNext()) {
            Department d = (Department) iterator.next();
            out.println(d.getName());
        }
    }
}
