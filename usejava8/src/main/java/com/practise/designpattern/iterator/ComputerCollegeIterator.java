package com.practise.designpattern.iterator;

import java.util.Iterator;

//��дIterator������ʵ��Ժ�ı���
public class ComputerCollegeIterator implements Iterator {
    Department[] departments;
    int position = 0; //��������λ��

    public ComputerCollegeIterator(Department[] departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        if (position >= departments.length || departments[position] == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object next() {
        Department department = departments[position];
        position += 1;
        return department;
    }

    @Override
    public void remove() {
    }
}
