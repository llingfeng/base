package com.mode.observermode.weatherplus;


/**
 * Created by admin on 2016/12/11.
 */
public interface Observer {

    void update(WeatherSubject weatherSubject);

    String getObserverName();

    void setObserverName(String observerName);

}
