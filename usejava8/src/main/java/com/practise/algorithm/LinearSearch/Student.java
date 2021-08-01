package com.practise.algorithm.LinearSearch;

public class Student implements Comparable<Student> {

    private String name;
    private Integer score;

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, Integer score) {
        this.name = name;
        this.score = score;
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

    @Override
    public int compareTo(Student other) {
        return this.score - other.score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
