package com.practise.designpattern.visitor;

public class Client {

	public static void main(String[] args) {
		//����ObjectStructure
		ObjectStructure objectStructure = new ObjectStructure();
		objectStructure.attach(new Man());
		objectStructure.attach(new Woman());

		//չʾ��ͬ���ֽ���µ� ���е�������͡�
		Success success = new Success();
		objectStructure.display(success);
		Fail fail = new Fail();
		objectStructure.display(fail);
		Wait wait = new Wait();
		objectStructure.display(wait);
	}

}
