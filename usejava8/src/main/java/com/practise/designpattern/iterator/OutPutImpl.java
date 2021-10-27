package com.practise.designpattern.iterator;

import java.util.Iterator;
import java.util.List;

import static java.lang.System.*;

/**
 * ���ñ�����ͳһ�������ѧԺ��ϵ
 */
public class OutPutImpl {
    List<College> collegeList;

    public OutPutImpl(List<College> collegeList) {
        this.collegeList = collegeList;
    }

    public void printCollege() {
        Iterator<College> iterator = collegeList.iterator();//1��*****list������б�������
        while (iterator.hasNext()) {
            College college = iterator.next();
            printDepartment(college.createIterator());//2��*****�������б���������ѧԺ
        }
    }

    public void printDepartment(Iterator iterator) {
        while (iterator.hasNext()) {
            Department d = (Department) iterator.next();
            out.println(d.getName());
        }
    }
}
