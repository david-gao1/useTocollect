package com.practise.designpattern.observer.improve;

import static java.lang.System.*;

public class Client {

    public static void main(String[] args) {
        //����subject
        WeatherData weatherData = new WeatherData();
        //������ע��۲���
        CurrentConditions currentConditions = new CurrentConditions();
        BaiduSite baiduSite = new BaiduSite();
        weatherData.registerObserver(currentConditions);
        weatherData.registerObserver(baiduSite);

        //��observer���и��¡��Ƴ�
        out.println("֪ͨ����ע��Ĺ۲���, ������Ϣ");
        weatherData.setData(10f, 100f, 30.3f);
        weatherData.removeObserver(currentConditions);
        out.println("֪ͨ����ע��Ĺ۲���, ������Ϣ");
        weatherData.setData(10f, 100f, 30.3f);
    }
}
