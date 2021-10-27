package com.practise.designpattern.interpreter;

import java.util.HashMap;


/**
 * "父类公共"：获取左右两边的表达式实例
 * 这里，每个运算符号，都只和自己左右两边有关系：
 *  两边可能是数字也可能是表达式 但都是Expression类的实现类
 */
public class SymbolExpression extends Expression {

    protected Expression left;
    protected Expression right;

    public SymbolExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }


    //默认实现，子类会实现
    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return 0;
    }
}
