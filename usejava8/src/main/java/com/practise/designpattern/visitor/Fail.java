package com.practise.designpattern.visitor;

import static java.lang.System.*;

public class Fail extends Action {
	@Override
	public void getManResult(Man man) {
		out.println(" ���˸������۸ø���ʧ�� !");
	}
	@Override
	public void getWomanResult(Woman woman) {
		out.println(" Ů�˸������۸ø���ʧ�� !");
	}
}
