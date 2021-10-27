package com.practise.designpattern.memento.theory;

public class Client {

    public static void main(String[] args) {


        Originator originator = new Originator();   //������Ķ���
        Caretaker caretaker = new Caretaker();      //�������״̬���б�

        //����״̬��ͨ��һ���������ò�ͬ��״̬�ŵ�caretaker�й���
        originator.setState(" ״̬#1 ������ 100 ");
        caretaker.add(originator.saveStateMemento());
        originator.setState(" ״̬#2 ������ 80 ");
        caretaker.add(originator.saveStateMemento());
        originator.setState(" ״̬#3 ������ 50 ");
        caretaker.add(originator.saveStateMemento());

        System.out.println("��ǰ��״̬�� =" + originator.getState());
        originator.getStateFromMemento(caretaker.get(0));  //ϣ���õ�״̬ 1, �� originator �ָ���״̬1
        System.out.println("�ָ���״̬1 , ��ǰ��״̬��");
        System.out.println("��ǰ��״̬�� =" + originator.getState());


    }

}
