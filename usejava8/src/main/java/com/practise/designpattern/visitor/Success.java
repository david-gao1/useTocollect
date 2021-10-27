package com.practise.designpattern.visitor;

import static java.lang.System.out;

public class Success extends Action {

	@Override
	public void getManResult(Man man) {
		out.println(" 男人给的评价该歌手很成功 !");
	}

	@Override
	public void getWomanResult(Woman woman) {
		out.println(" 女人给的评价该歌手很成功 !");
	}

}
