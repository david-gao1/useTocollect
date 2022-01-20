package com.practise.java8.useException;

import java.io.File;
import java.io.IOException;

/**
 * 异常转义就是将一种类型的异常转成另一种类型的异常，然后再抛出异常。之所以要进行转译，是为了更准确的描述异常。
 *
 */
class MyException extends Exception {
    public MyException(String msg, Throwable e) {
        super(msg, e);
    }
}


class Demo {
    public static void main(String[] args) throws MyException {
        File file = new File("h：//test.txt");
            try {
                file.createNewFile();
            } catch (IOException e) {
               throw new MyException("file create failed", e);
            }
    }
}