package com.mode.observermode.weatherplus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/12/11.
 */
public abstract class WeatherSubject {
    List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void detach(Observer observer){
        observers.remove(observer);
    }

    protected abstract void notifyObservers();
}
