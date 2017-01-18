package com.mode.observermode.weatherbasejavautil;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by admin on 2016/12/11.
 */
public class ConcreteObserver implements Observer{
    private String observerName;

    public String getObserverName() {
        return observerName;
    }

    public void setObserverName(String observerName) {
        this.observerName = observerName;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(observerName+"推方式接收到了消息："+arg);
        System.out.println(observerName+"拉方式接收到了消息："+((ConcreteWeatherSubject)o).getContent());
    }
}
