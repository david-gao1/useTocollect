package com.practise.designpattern.interpreter;

import java.util.HashMap;

public class SubtractionExpression extends SymbolExpression {

	public SubtractionExpression(Expression left, Expression right) {
		super(left, right);
	}

	//���left �� right ���ʽ�����Ľ��
	@Override
	public int interpreter(HashMap<String, Integer> var) {
		return super.left.interpreter(var) - super.right.interpreter(var);
	}
}
