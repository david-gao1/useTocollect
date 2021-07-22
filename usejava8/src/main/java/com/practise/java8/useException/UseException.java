package com.practise.java8.useException;

public class UseException {
    public static void main(String[] args) throws AgeException {
        if (100>1){
            throw new AgeException("年龄超过范围");
            //会得到getMessage的信息
        }
    }
}
