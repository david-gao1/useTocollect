package com.practise.designpattern.command;

public class LightOffCommand implements Command {
    // �ۺ� LightReceiver
    LightReceiver light;
    public LightOffCommand(LightReceiver light) {
        super();
        this.light = light;
    }
    @Override
    public void execute() { light.off(); }
    @Override
    public void undo() { light.on(); }
}
