package com.Book;

/**
 * Created by admin on 2016/8/29.
 */
public class Book {
    private int bookSerialNum;//序号
    private String bookName;//书名

    public Book(int bookSerialNum,String bookName){
        this.bookSerialNum = bookSerialNum;
        this.bookName = bookName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookSerialNum() {
        return bookSerialNum;
    }

    public void setBookSerialNum(int bookSerialNum) {
        this.bookSerialNum = bookSerialNum;
    }
}
