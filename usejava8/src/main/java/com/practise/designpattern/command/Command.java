package com.practise.designpattern.command;



public interface Command {
    void execute();//执行动作(操作)
    void undo();//撤销动作(操作)
}
