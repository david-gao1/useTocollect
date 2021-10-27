package com.practise.designpattern.visitor;

//��������ʹ�õ���˫����
//1. ���ɲ����������ڿͻ��˳����У�������״̬��Ϊ��������Woman��(��һ�η���)
//2. ���ɶ���Ȼ��Woman ����ã���Ϊ������ "���巽��" �У�����getWomanResult, ͬʱ���Լ�(this)��Ϊ�������룬��ɵڶ��εķ���

//���ݶ�������Ͷ��Է������е�ѡ��,���Ƿ���(Dispatch)�����ӣ���̬��
//��accept�ķ���ʵ����,����this��ȥ �����visitor����this������,�������һ�η���,�ҵ�����Ҫ���õķ���
public class Woman extends Person{

	@Override
	public void accept(Action action) {
		action.getWomanResult(this);
	}

}
