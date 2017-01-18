package com.mode.observermode.weather;

import java.util.ArrayList;
import java.util.List;

/**
 * 目标对象:它知道观察它的观察者，并提供注册（添加）和删除观察者对象的接口
 * Created by admin on 2016/12/11.
 */
public class WeatherSubject {
    //观察者对象集合
    List<Observer> observers = new ArrayList<>();

    //attach detach notifyObservers
    //添加订阅天气的用户
    public void attach(Observer observer){
        observers.add(observer);
    }

    //删除订阅天气的用户
    public void detach(Observer observer){
        observers.remove(observer);
    }

    //通知订阅天气的用户
    protected void notifyObservers(){
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}
