package com.practise.designpattern.iterator;

import java.util.Iterator;

public class ComputerCollege implements College {
    Department[] departments;
    int numOfDepartment; //��¼���������

    public ComputerCollege() {
        departments = new Department[5];
        addDepartment("Javaרҵ", " Javaרҵ ");
        addDepartment("PHPרҵ", " PHPרҵ ");
        addDepartment("������רҵ", " ������רҵ ");
    }

    @Override
    public void addDepartment(String name, String desc) {
        Department department = new Department(name, desc);
        departments[numOfDepartment] = department;
        numOfDepartment += 1;
    }

    @Override
    public String getName() {
        return "�����ѧԺ";
    }

    @Override
    public Iterator createIterator() {
        return new ComputerCollegeIterator(departments);
    }
}
