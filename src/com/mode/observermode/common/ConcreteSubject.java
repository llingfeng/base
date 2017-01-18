package com.mode.observermode.common;

/**
 * 具体的目标对象，负责把有关状态存入到观察者对象中
 * Created by admin on 2016/12/11.
 */
public class ConcreteSubject extends Subject {
    //目标对象的状态
    private String subjectState;

    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
        this.notifyObservers();
    }
}
