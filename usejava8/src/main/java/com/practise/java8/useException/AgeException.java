package com.practise.java8.useException;

/**
 * a、继承异常类
 * b、添加有参构造器
 * c、复写父类方法
 *
 */
public class AgeException extends Exception {

    private String message;

    public AgeException() {
    }

    /**
     * 抛出异常的时候可以将信息传给调用者
     *
     * @param message
     */
    public AgeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "getMessage:" + message;
    }

//    @Override
//    public String toString() {
//        return "message:" + message;
//    }

    @Override
    public void printStackTrace() {
        System.out.println("printStackTrace:" + message);
    }
}
