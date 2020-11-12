package org.example.observer.improve;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/12 23:53
 */
public class Client {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        weatherData.registerObserver(new CurrentConditions());
        weatherData.registerObserver(new CurrentConditions());

        weatherData.setData(30, 150, 40);
        System.out.println("---weather changed---");
        weatherData.setData(20, 160, 20);
    }
}
