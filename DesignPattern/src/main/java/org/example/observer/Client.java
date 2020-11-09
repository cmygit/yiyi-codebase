package org.example.observer;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/10 0:23
 */
public class Client {

    public static void main(String[] args) {
        CurrentConditions currentConditions = new CurrentConditions();
        WeatherData weatherData = new WeatherData(currentConditions);

        weatherData.setData(30, 150, 40);
        System.out.println("---weather changed---");
        weatherData.setData(20, 160, 20);
    }
}
