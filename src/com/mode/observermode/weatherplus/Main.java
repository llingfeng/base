package com.mode.observermode.weatherplus;

/**
 * Created by admin on 2016/12/11.
 */
public class Main {
    public static void main(String[] args){
        ConcreteWeatherSubject concreteWeatherSubject = new ConcreteWeatherSubject();

        ConcreteObserver girl = new ConcreteObserver();
        girl.setObserverName("王明老婆");
        girl.setAttention("约会，看电影");

        ConcreteObserver mum = new ConcreteObserver();
        mum.setObserverName("王明岳母");
        mum.setAttention("逛街");

        concreteWeatherSubject.attach(girl);
        concreteWeatherSubject.attach(mum);

        concreteWeatherSubject.setContent("下雪");
    }
}
