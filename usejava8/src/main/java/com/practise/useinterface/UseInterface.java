package com.practise.useinterface;

import com.practise.useOOP.Stu;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;


public class UseInterface {
    public static void main(String[] args) {
        //useTimer();
        //comparable:实现对象数组排序
        Employee[] employees = new Employee[3];
        employees[0] = new Employee("dada", 77, "walking");
        employees[1] = new Employee("xiaoxiao", 12, "walking");
        employees[2] = new Employee("hahao", 75, "walking");
        Arrays.sort(employees); //按照age进行排序
        System.out.print(Arrays.toString(employees));

        //comparator:对象数组排序
        Stu[] stus = new Stu[3];
        stus[0] = new Stu("dada", 77, "walking");
        stus[1] = new Stu("xiaoxiao", 12, "walking");
        stus[2] = new Stu("hahao", 75, "walking");
        Arrays.sort(stus, Comparator.comparing(Stu::getAge));
        Arrays.sort(stus, (Stu s1, Stu s2) -> s1.getAge().compareTo(s2.getAge()));
        System.out.print(Arrays.toString(stus));


    }


    private static void useTimer() {
        ActionListener listener = new TimePrinter();
        /**
         * 构造一个定时器， 每隔 interval 毫秒通告 listener—次，
         */
        Timer timer = new Timer(1000, listener); //周期性的调用对象。即周期性的实现消息信息的发送。
        /**
         * 启动定时器一旦启动成功， 定时器将调用监听器的 actionPerformed。
         */
        timer.start();
        /**
         * 显示一个包含一条消息和 OK 按钮的对话框。这个对话框将位于其parent组件的中
         *  央。如果parent为null，对话框将显示在屏幕的中央
         */
        JOptionPane.showMessageDialog(null, "Quit program？");
        System.exit(0);
    }
}
