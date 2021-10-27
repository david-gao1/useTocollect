package com.practise.designpattern.visitor;

import static java.lang.System.out;

public class Success extends Action {

	@Override
	public void getManResult(Man man) {
		out.println(" ���˸������۸ø��ֺܳɹ� !");
	}

	@Override
	public void getWomanResult(Woman woman) {
		out.println(" Ů�˸������۸ø��ֺܳɹ� !");
	}

}
