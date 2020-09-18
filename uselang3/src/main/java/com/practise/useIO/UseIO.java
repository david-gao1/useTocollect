package com.practise.useIO;

import java.io.File;

public class UseIO {
    public static void main(String[] args) {
        String localfileDir="C:\\Users\\v_liangggao\\Desktop\\11\\11.txt";
        File newFile = new File(localfileDir);
        System.out.println(newFile.getParentFile().exists());
        if (!newFile.getParentFile().exists()) {
            newFile.getParentFile().mkdirs();

        }

    }
}
