package com.practise.designpattern.mediator.smarthouse;

import static java.lang.System.*;

public class CoffeeMachine extends Colleague {
	public CoffeeMachine(Mediator mediator, String name) {
		super(mediator, name);
		mediator.Register(name, this);
	}
	@Override
	public void SendMessage(int stateChange) { this.GetMediator().GetMessage(stateChange, this.name); }
	public void StartCoffee() { out.println("It's time to startcoffee!"); }
	public void FinishCoffee() {
		out.println("After 5 minutes!");
		out.println("Coffee is ok!");
		SendMessage(0);
	}
}
