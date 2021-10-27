package com.practise.designpattern.visitor;

//这里我们使用到了双分派
//1. 分派参数：首先在客户端程序中，将具体状态作为参数传递Woman中(第一次分派)
//2. 分派对象：然后Woman 类调用（作为参数的 "具体方法" 中）方法getWomanResult, 同时将自己(this)作为参数传入，完成第二次的分派

//根据对象的类型而对方法进行的选择,就是分派(Dispatch)。例子：多态。
//在accept的方法实现中,传递this进去 具体的visitor根据this的类型,又完成了一次分派,找到了需要调用的方法
public class Woman extends Person{

	@Override
	public void accept(Action action) {
		action.getWomanResult(this);
	}

}
