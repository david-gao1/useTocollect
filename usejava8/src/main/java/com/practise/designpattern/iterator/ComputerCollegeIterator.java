package com.practise.designpattern.iterator;

import java.util.Iterator;

//重写Iterator方法，实现院的遍历
public class ComputerCollegeIterator implements Iterator {
    Department[] departments;
    int position = 0; //遍历到的位置

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
