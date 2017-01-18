package com.mode.observermode.common;

/**
 * 具体的观察者对象，实现更新的方法，使自身的状态与目标状体保持一致
 * Created by admin on 2016/12/11.
 */
public class ConcreteObserver implements Observer {
    //观察者的状态
    private String observerState;
    @Override
    public void update(Subject subject) {
        observerState = ((ConcreteSubject)subject).getSubjectState();
    }
}
