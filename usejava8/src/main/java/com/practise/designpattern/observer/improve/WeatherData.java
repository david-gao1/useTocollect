package com.practise.designpattern.observer.improve;

import java.util.ArrayList;

/**
 * ���Ǻ���
 * 1. �������µ����������Ϣ
 * 2. ���� �۲��߼��ϣ�ʹ��ArrayList����
 * 3. �������и���ʱ���������ĵ���   ArrayList, ֪ͨ���еģ����뷽���Ϳ������µ���Ϣ
 *
 * @author Administrator
 */
public class WeatherData implements Subject {
    private float temperatrue;
    private float pressure;
    private float humidity;
    //***�۲��߼��ϣ����ڹ��������
    private ArrayList<Observer> observers;
    //todo�������µĵ�����

    public WeatherData() {
        observers = new ArrayList<Observer>();
    }

    public float getTemperature() {
        return temperatrue;
    }

    public float getPressure() {
        return pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void dataChange() {
        notifyObservers();
    }

    //�������и���ʱ���͵��� setData
    public void setData(float temperature, float pressure, float humidity) {
        this.temperatrue = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        //����dataChange�� �����µ���Ϣ ���͸� ���뷽 currentConditions
        dataChange();
    }

    //֪ͨʱ����¹۲��ߵ�����
    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update(this.temperatrue, this.pressure, this.humidity);
        }
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) { observers.remove(o); }
}
