package com.practise.designpattern.observer.improve;

import static java.lang.System.*;

public class BaiduSite implements Observer {
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

    public void display() {
        out.println("===�ٶ���վ====");
        out.println("***�ٶ���վ ���� : " + temperature + "***");
        out.println("***�ٶ���վ ��ѹ: " + pressure + "***");
        out.println("***�ٶ���վ ʪ��: " + humidity + "***");
    }
}
