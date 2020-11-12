package org.example.observer.improve;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/12 23:47
 */
public class CurrentConditions implements Observer {

    private float temperature;

    private float pressure;

    private float humidity;

    @Override
    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.display();
    }

    public void display() {
        System.out.println("***Today mTemperature: " + this.temperature + "***");
        System.out.println("***Today mPressure: " + this.pressure + "***");
        System.out.println("***Today mHumidity: " + this.humidity + "***");
    }
}
