package com.practise.designpattern.memento.game;

//�ػ��߶���, ������Ϸ��ɫ��״̬
public class Caretaker {


	private Memento  memento;  //���ֻ����һ��״̬
	//��GameRole ������״̬   private ArrayList<Memento> mementos;
	//�Զ����Ϸ��ɫ������״̬  private HashMap<String, ArrayList<Memento>> rolesMementos;

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(Memento memento) {
		this.memento = memento;
	}
	
	
}
