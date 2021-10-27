package com.practise.designpattern.mediator.smarthouse;

public class ClientTest {

    public static void main(String[] args) {
        //����һ���н��߶���
        Mediator mediator = new ConcreteMediator();
        //1��****���������ͬʱ��ע�ᵽ�н��߶�����
        Alarm alarm = new Alarm(mediator, "alarm");
        CoffeeMachine coffeeMachine = new CoffeeMachine(mediator, "coffeeMachine");
        Curtains curtains = new Curtains(mediator, "curtains");
        TV tV = new TV(mediator, "TV");

        //2�����ӷ���ʱ���ᴥ������colleague���������
        //���̶������н���������
        alarm.SendAlarm(0);
        coffeeMachine.FinishCoffee();
        alarm.SendAlarm(1);
    }

}
