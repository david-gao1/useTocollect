package com.practise.java8.useIO;

import java.io.File;
import java.nio.file.Paths;

public class UseIO {
    public static void main(String[] args) {
        String localfileDir="\\etc\\pass\\1.txt\\1";
        File newFile = new File(localfileDir);
        System.out.println(newFile.getParentFile().exists());
        if (!newFile.getParentFile().exists()) {
            newFile.getParentFile().mkdirs();
        }

        countPathName(localfileDir);

    }

    private static void countPathName(String localfileDir) {
        final int nameCount = Paths.get(localfileDir).getNameCount();
        System.out.println(nameCount);
    }
}
