package com.practise.designpattern.observer.improve;

import static java.lang.System.*;

public class BaiduSite implements Observer {
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

    public void display() {
        out.println("===百度网站====");
        out.println("***百度网站 气温 : " + temperature + "***");
        out.println("***百度网站 气压: " + pressure + "***");
        out.println("***百度网站 湿度: " + humidity + "***");
    }
}
