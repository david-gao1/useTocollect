package com.practise.designpattern.interpreter;

import java.util.HashMap;


/**
 * 变量解释器：设置变量
 */
public class VarExpression extends Expression {

	private String key; // key=a,key=b,key=c

	public VarExpression(String key) {
		this.key = key;
	}

	@Override
	public int interpreter(HashMap<String, Integer> var) {
		return var.get(this.key);
	}
}
