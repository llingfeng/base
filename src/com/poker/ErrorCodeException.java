package com.poker;

/**
 * Created by admin on 2016/8/30.
 */
public class ErrorCodeException extends Exception{
    public ErrorCodeException(){

    }

    public ErrorCodeException(String message){
        super(message);
    }
}
