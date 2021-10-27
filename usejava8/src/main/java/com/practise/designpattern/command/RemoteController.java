package com.practise.designpattern.command;


//调用者：封装了调用逻辑
public class RemoteController {
    //按钮的命令数组
    Command[] onCommands;
    Command[] offCommands;
    //执行撤销的命令
    Command undoCommand;

    public RemoteController() {
        // 构造器，完成对按钮初始化
        onCommands = new Command[5];
        offCommands = new Command[5];
        for (int i = 0; i < 5; i++) {
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }
    }

    //按照序号存储不同类型的命令实例
    public void setCommand(int no, Command onCommand, Command offCommand) {
        onCommands[no] = onCommand;
        offCommands[no] = offCommand;
    }
    //按下开按钮
    public void onButtonWasPushed(int no) { // no 0
        onCommands[no].execute(); //按照序号找到命令实例
        undoCommand = onCommands[no];// 记录这次的操作，用于撤销
    }
    // 按下关按钮
    public void offButtonWasPushed(int no) { // no 0
        offCommands[no].execute();
        undoCommand = offCommands[no];
    }
    // 按下撤销按钮
    public void undoButtonWasPushed() {
        undoCommand.undo();
    }
}
