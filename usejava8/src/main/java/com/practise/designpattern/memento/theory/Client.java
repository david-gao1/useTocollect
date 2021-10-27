package com.practise.designpattern.memento.theory;

public class Client {

    public static void main(String[] args) {


        Originator originator = new Originator();   //被保存的对象
        Caretaker caretaker = new Caretaker();      //保存对象（状态）列表

        //保存状态：通过一个对象设置不同的状态放到caretaker中管理
        originator.setState(" 状态#1 攻击力 100 ");
        caretaker.add(originator.saveStateMemento());
        originator.setState(" 状态#2 攻击力 80 ");
        caretaker.add(originator.saveStateMemento());
        originator.setState(" 状态#3 攻击力 50 ");
        caretaker.add(originator.saveStateMemento());

        System.out.println("当前的状态是 =" + originator.getState());
        originator.getStateFromMemento(caretaker.get(0));  //希望得到状态 1, 将 originator 恢复到状态1
        System.out.println("恢复到状态1 , 当前的状态是");
        System.out.println("当前的状态是 =" + originator.getState());


    }

}
