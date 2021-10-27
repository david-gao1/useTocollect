package com.practise.designpattern.visitor;

public class Client {

	public static void main(String[] args) {
		//创建ObjectStructure
		ObjectStructure objectStructure = new ObjectStructure();
		objectStructure.attach(new Man());
		objectStructure.attach(new Woman());

		//展示不同评分结果下的 所有的组合类型。
		Success success = new Success();
		objectStructure.display(success);
		Fail fail = new Fail();
		objectStructure.display(fail);
		Wait wait = new Wait();
		objectStructure.display(wait);
	}

}
