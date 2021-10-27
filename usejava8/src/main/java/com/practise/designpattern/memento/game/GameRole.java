package com.practise.designpattern.memento.game;

public class GameRole {

	private int vit;
	private int def;
	
	//创建状态（实例），将状态（实例）放到caretaker的状态列表中
	public Memento createMemento() {
		return new Memento(vit, def);
	}
	
	//通过备忘录对象重新设置值
	public void recoverGameRoleFromMemento(Memento memento) {
		this.vit = memento.getVit();
		this.def = memento.getDef();
	}
	
	//显示当前游戏角色的状态
	public void display() {
		System.out.println("游戏角色当前的攻击力：" + this.vit + " 防御力: " + this.def);
	}

	public int getVit() {
		return vit;
	}

	public void setVit(int vit) {
		this.vit = vit;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}
	
	
}
