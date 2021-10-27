package com.practise.designpattern.mediator.smarthouse;

public abstract class Mediator {
    //�����н��߶��󣬼��뵽������
    public abstract void Register(String colleagueName, Colleague colleague);
    //������Ϣ, ��֯�����colleague�����ִ���߼�
    public abstract void GetMessage(int stateChange, String colleagueName);
    public abstract void SendMessage();
}
