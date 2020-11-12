package org.example.observer.improve;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/12 23:46
 */
public interface Observer {

    void update(float temperature, float pressure, float humidity);
}
