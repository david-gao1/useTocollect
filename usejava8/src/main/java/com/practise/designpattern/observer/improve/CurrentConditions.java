package com.practise.designpattern.observer.improve;

import static java.lang.System.*;

public class CurrentConditions implements Observer {

	// 温度，气压，湿度
	private float temperature;
	private float pressure;
	private float humidity;

	// 更新 天气情况，是由 WeatherData 来调用，我使用推送模式
	@Override
	public void update(float temperature, float pressure, float humidity) {
		this.temperature = temperature;
		this.pressure = pressure;
		this.humidity = humidity;
		display();
	}

	// 显示
	public void display() {
		out.println("***Today mTemperature: " + temperature + "***");
		out.println("***Today mPressure: " + pressure + "***");
		out.println("***Today mHumidity: " + humidity + "***");
	}
}
