package com.practise.designpattern.mediator.smarthouse;

//同事抽象类：实现了对中介者的注册
public abstract class Colleague {
    private Mediator mediator;
    public String name;

    public Colleague(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }
    public Mediator GetMediator() {
        return this.mediator;
    }
    public abstract void SendMessage(int stateChange);
}
