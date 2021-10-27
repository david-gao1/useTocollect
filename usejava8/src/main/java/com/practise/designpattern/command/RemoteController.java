package com.practise.designpattern.command;


//�����ߣ���װ�˵����߼�
public class RemoteController {
    //��ť����������
    Command[] onCommands;
    Command[] offCommands;
    //ִ�г���������
    Command undoCommand;

    public RemoteController() {
        // ����������ɶ԰�ť��ʼ��
        onCommands = new Command[5];
        offCommands = new Command[5];
        for (int i = 0; i < 5; i++) {
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }
    }

    //������Ŵ洢��ͬ���͵�����ʵ��
    public void setCommand(int no, Command onCommand, Command offCommand) {
        onCommands[no] = onCommand;
        offCommands[no] = offCommand;
    }
    //���¿���ť
    public void onButtonWasPushed(int no) { // no 0
        onCommands[no].execute(); //��������ҵ�����ʵ��
        undoCommand = onCommands[no];// ��¼��εĲ��������ڳ���
    }
    // ���¹ذ�ť
    public void offButtonWasPushed(int no) { // no 0
        offCommands[no].execute();
        undoCommand = offCommands[no];
    }
    // ���³�����ť
    public void undoButtonWasPushed() {
        undoCommand.undo();
    }
}
