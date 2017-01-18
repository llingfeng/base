package com.mode.observermode.weatherplus;

/**
 * Created by admin on 2016/12/11.
 */
public class ConcreteObserver implements Observer {

    private String observerName;
    private String content;
    private String attention;
    @Override
    public void update(WeatherSubject weatherSubject) {
        content = ((ConcreteWeatherSubject)weatherSubject).getContent();
        System.out.println(observerName+"收到信息："+content+"注意事项："+attention);
    }

    public String getObserverName() {
        return observerName;
    }

    public void setObserverName(String observerName) {
        this.observerName = observerName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }
}
