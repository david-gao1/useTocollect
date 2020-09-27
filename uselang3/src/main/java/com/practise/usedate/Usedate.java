package com.practise.usedate;

import java.sql.Timestamp;

public class Usedate {
    public static void main(String[] args) {

        getTimeStampbyString();
    }

    private static void getTimeStampbyString() {
        String tsStr = "2020-09-27 10:57:23";
        Timestamp ts = Timestamp.valueOf(tsStr);  // 2011-05-09 11:49:45.0
        final long time = ts.getTime(); //转为时间戳
        System.out.println(time);
    }
}
