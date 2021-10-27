package com.practise.designpattern.interpreter;

import java.util.HashMap;

/**
 * 抽象1：
 * 实现类可以是变量、加法、减法类
 */
public abstract class Expression {

    /**
     * 通过解释器计算得出结果后，作为整个表达式左右两边的元素，进行迭代计算
     *
     * @param var
     * @return
     */
    public abstract int interpreter(HashMap<String, Integer> var);
}
