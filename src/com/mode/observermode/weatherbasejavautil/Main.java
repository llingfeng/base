package com.mode.observermode.weatherbasejavautil;

/**
 * Created by admin on 2016/12/11.
 */
public class Main {
    public static void main(String[] args){
        ConcreteWeatherSubject concreteWeatherSubject = new ConcreteWeatherSubject();

        ConcreteObserver girl = new ConcreteObserver();
        girl.setObserverName("王明老婆");

        ConcreteObserver mum = new ConcreteObserver();
        mum.setObserverName("王明岳母");

        concreteWeatherSubject.addObserver(girl);
        concreteWeatherSubject.addObserver(mum);

        concreteWeatherSubject.setContent("天气晴朗，气温29度");
    }
}
