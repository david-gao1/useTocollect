package com.practise.designpattern.memento.theory;

public class Originator {

	private String state;//״̬��Ϣ

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	

	//ÿ����һ�η����ͻᴴ��һ��"״̬"����
	public Memento saveStateMemento() {
		return new Memento(state);
	}
	
	//��caretaker��״̬�б��л�ȡ��ͬ��״̬ʵ��
	public void getStateFromMemento(Memento memento) {
		state = memento.getState();
	}
}
