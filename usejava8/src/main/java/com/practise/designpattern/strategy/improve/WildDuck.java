package com.practise.designpattern.strategy.improve;

public class WildDuck extends Duck {
	public  WildDuck() {
		//����FlyBehavor�Ķ��󣨵��������ԣ�
		flyBehavior = new GoodFlyBehavior();
	}

	@Override
	public void display() {
		System.out.println(" ����ҰѼ ");
	}
}
