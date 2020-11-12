package org.example.observer.improve;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/12 23:49
 */
public class WeatherData implements Subject {

    private float temperature;

    private float pressure;

    private float humidity;

    private List<Observer> observers;

    public WeatherData() {
        this.observers = new ArrayList<>();
    }

    public void dataChanged() {
        this.notifyObservers();
    }

    public void setData(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.dataChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    @Override
    public void registerObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        this.observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : this.observers) {
            observer.update(this.getTemperature(), this.getPressure(), this.getHumidity());
        }
    }
}
