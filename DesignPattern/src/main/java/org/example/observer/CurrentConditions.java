package org.example.observer;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/10 0:01
 */
public class CurrentConditions {

    private float temperature;

    private float pressure;

    private float humidity;

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
