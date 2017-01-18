package com.mode.observermode.weather;

/**
 * 具体的目标对象，负责把有关状态存入到观察者对象中
 * Created by admin on 2016/12/11.
 */
public class WeatherConcreteSubject extends WeatherSubject {
    //目标对象的状态
    private String weatherState;

    public String getWeatherState() {
        return weatherState;
    }

    public void setWeatherState(String weatherState) {
        this.weatherState = weatherState;
        this.notifyObservers();
    }
}
