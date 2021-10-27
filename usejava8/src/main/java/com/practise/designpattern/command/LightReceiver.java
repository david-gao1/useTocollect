package com.practise.designpattern.command;

import static java.lang.System.*;

public class LightReceiver {
	public void on() { out.println(" 电灯打开了.. "); }
	public void off() { out.println(" 电灯关闭了.. "); }
}
