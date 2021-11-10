package com.practise.designpattern.strategy.improve;

public abstract class Duck {

    //属性, 策略接口
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    //通过聚合的方式将策略（鸭子的属性）接口放到接口A中，通过给接口A实现类传递不同的行为实例，来改变行为
    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public abstract void display();

    public void quack() {
        System.out.println("鸭子嘎嘎叫~~");
    }

    public void swim() {
        System.out.println("鸭子会游泳~~");
    }

    public void fly() {
        if (flyBehavior != null) {
            flyBehavior.fly();
        }
    }
}
