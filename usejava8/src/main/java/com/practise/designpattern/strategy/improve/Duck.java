package com.practise.designpattern.strategy.improve;

public abstract class Duck {

    //����, ���Խӿ�
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    //ͨ���ۺϵķ�ʽ�����ԣ�Ѽ�ӵ����ԣ��ӿڷŵ��ӿ�A�У�ͨ�����ӿ�Aʵ���ഫ�ݲ�ͬ����Ϊʵ�������ı���Ϊ
    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public abstract void display();

    public void quack() {
        System.out.println("Ѽ�Ӹ¸½�~~");
    }

    public void swim() {
        System.out.println("Ѽ�ӻ���Ӿ~~");
    }

    public void fly() {
        if (flyBehavior != null) {
            flyBehavior.fly();
        }
    }
}
