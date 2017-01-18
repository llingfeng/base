package com.mode.observermode.weather;

/**
 * 具体的观察者对象，实现更新的方法，使自身的状态与目标状体保持一致
 * Created by admin on 2016/12/11.
 */
public class ConcreteObserver implements Observer {
    //通知用户的信息（用户名，天气状况，注意事项）
    private String username;
    private String weatherState;
    private String attention;
    @Override
    public void update(WeatherSubject weatherSubject) {
        weatherState = ((WeatherConcreteSubject) weatherSubject).getWeatherState();
        System.out.println(username+"，"+weatherState+"，"+attention);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWeatherState() {
        return weatherState;
    }

    public void setWeatherState(String weatherState) {
        this.weatherState = weatherState;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }
}
