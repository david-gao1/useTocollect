package com.practise.algorithm.LinearSearch;

public class Student {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    /**
     * 实现的是Object的equals
     */
    @Override
    public boolean equals(Object student) {
        //1、判断是否是此对象本身
        if (this == student) {
            return true;
        }
        if (student == null) {
            return false;
        }
        //先判断类对象是否一致，一致再进行强制类型转换
        if (this.getClass() != student.getClass()) {
            return false;
        }
        Student another = (Student) student;
        return this.name.equals(another.name);
    }
}
