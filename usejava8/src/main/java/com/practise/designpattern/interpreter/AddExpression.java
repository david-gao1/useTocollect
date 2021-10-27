package com.practise.designpattern.interpreter;

import java.util.HashMap;

/**
 * ¼Ó·¨½âÊÍÆ÷
 *
 * @author Administrator
 */
public class AddExpression extends SymbolExpression {

    public AddExpression(Expression left, Expression right) {
        super(left, right);
    }


    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return super.left.interpreter(var) + super.right.interpreter(var);
    }
}
