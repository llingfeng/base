package com.Book;

/**
 * Created by admin on 2016/8/29.
 */
public class NoExistBookException extends Exception {
    public NoExistBookException(){

    }
    public NoExistBookException(String message){
        super(message);
    }
}
