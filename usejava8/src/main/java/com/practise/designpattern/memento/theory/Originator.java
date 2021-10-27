package com.practise.designpattern.memento.theory;

public class Originator {

	private String state;//状态信息

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	

	//每调用一次方法就会创建一个"状态"对象
	public Memento saveStateMemento() {
		return new Memento(state);
	}
	
	//从caretaker的状态列表中获取不同的状态实例
	public void getStateFromMemento(Memento memento) {
		state = memento.getState();
	}
}
