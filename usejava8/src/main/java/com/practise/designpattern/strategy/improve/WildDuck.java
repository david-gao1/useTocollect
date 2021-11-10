package com.practise.designpattern.strategy.improve;

public class WildDuck extends Duck {
	public  WildDuck() {
		//传入FlyBehavor的对象（到父类属性）
		flyBehavior = new GoodFlyBehavior();
	}

	@Override
	public void display() {
		System.out.println(" 这是野鸭 ");
	}
}
