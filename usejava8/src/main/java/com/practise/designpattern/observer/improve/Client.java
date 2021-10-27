package com.practise.designpattern.observer.improve;

import static java.lang.System.*;

public class Client {

    public static void main(String[] args) {
        //创建subject
        WeatherData weatherData = new WeatherData();
        //创建并注册观察者
        CurrentConditions currentConditions = new CurrentConditions();
        BaiduSite baiduSite = new BaiduSite();
        weatherData.registerObserver(currentConditions);
        weatherData.registerObserver(baiduSite);

        //对observer进行更新、移除
        out.println("通知各个注册的观察者, 看看信息");
        weatherData.setData(10f, 100f, 30.3f);
        weatherData.removeObserver(currentConditions);
        out.println("通知各个注册的观察者, 看看信息");
        weatherData.setData(10f, 100f, 30.3f);
    }
}
