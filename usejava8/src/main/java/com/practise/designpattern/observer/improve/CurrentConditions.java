package com.practise.designpattern.observer.improve;

import static java.lang.System.*;

public class CurrentConditions implements Observer {

	// �¶ȣ���ѹ��ʪ��
	private float temperature;
	private float pressure;
	private float humidity;

	// ���� ������������� WeatherData �����ã���ʹ������ģʽ
	@Override
	public void update(float temperature, float pressure, float humidity) {
		this.temperature = temperature;
		this.pressure = pressure;
		this.humidity = humidity;
		display();
	}

	// ��ʾ
	public void display() {
		out.println("***Today mTemperature: " + temperature + "***");
		out.println("***Today mPressure: " + pressure + "***");
		out.println("***Today mHumidity: " + humidity + "***");
	}
}
