package com.mode.observermode.weatherbasejavautil;

import java.util.Observable;

/**
 * Created by admin on 2016/12/11.
 */
public class ConcreteWeatherSubject extends Observable {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        this.setChanged();
        this.notifyObservers(content);
    }
}
