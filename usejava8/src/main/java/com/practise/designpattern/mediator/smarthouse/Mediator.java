package com.practise.designpattern.mediator.smarthouse;

public abstract class Mediator {
    //将给中介者对象，加入到集合中
    public abstract void Register(String colleagueName, Colleague colleague);
    //接收消息, 组织具体的colleague对象的执行逻辑
    public abstract void GetMessage(int stateChange, String colleagueName);
    public abstract void SendMessage();
}
