package com.practise.designpattern.mediator.smarthouse;

//具体的同事类
public class Alarm extends Colleague {
	public Alarm(Mediator mediator, String name) {
		super(mediator, name);
		//创建的同时注册
		mediator.Register(name, this);
	}
	public void SendAlarm(int stateChange) {
		SendMessage(stateChange);
	}
	@Override
	public void SendMessage(int stateChange) {
		//调用的中介者对象的getMessage
		this.GetMediator().GetMessage(stateChange, this.name);
	}
}
