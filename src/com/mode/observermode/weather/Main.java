package com.mode.observermode.weather;

/**
 * Created by admin on 2016/12/11.
 */
public class Main {
    public static void main(String[] args){
        //创建目标对象
        WeatherConcreteSubject weatherConcreteSubject = new WeatherConcreteSubject();
        //创建观察者对象
        ConcreteObserver girl = new ConcreteObserver();
        girl.setUsername("王明老婆");
        girl.setAttention("约会，看电影");

        ConcreteObserver mum = new ConcreteObserver();
        mum.setUsername("王明岳母");
        mum.setAttention("逛街");
        //注册观察者对象
        weatherConcreteSubject.attach(girl);
        weatherConcreteSubject.attach(mum);
        //目标发布天气
        weatherConcreteSubject.setWeatherState("天气不错");
    }
}
