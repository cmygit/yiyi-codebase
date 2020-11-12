package org.example.observer.improve;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/12 23:45
 */
public interface Subject {

    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}
