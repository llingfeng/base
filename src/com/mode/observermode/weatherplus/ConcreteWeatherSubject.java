package com.mode.observermode.weatherplus;

/**
 * Created by admin on 2016/12/11.
 */
public class ConcreteWeatherSubject extends WeatherSubject{
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        this.notifyObservers();
    }

    @Override
    protected void notifyObservers() {
        for (Observer observer : observers) {
            String observerName = observer.getObserverName();
            if("下雨".equals(content)){
                if("王明老婆".equals(observerName) || "王明岳母".equals(observerName)){
                    observer.update(this);
                }
            }
            if("下雪".equals(content)){
                if("王明岳母".equals(observerName)){
                    observer.update(this);
                }
            }
        }
    }
}
