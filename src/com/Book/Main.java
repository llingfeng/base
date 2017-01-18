package com.Book;

import java.util.Scanner;

/**
 * Created by admin on 2016/8/29.
 */
public class Main {
    Book[] books = {new Book(101,"语文"),new Book(102,"数学"),new Book(102,"英语")};

    public static void main(String[] args){
        Main main = new Main();
        while (true){
            int command = 0;
            try {
                command = main.command();
            } catch (ErrorCodeException e) {
                System.out.print(e.getMessage());
            }
            if(command == 1){
                try {
                    main.noExistBook();
                } catch (NoExistBookException e) {
                    System.out.print(e.getMessage());
                }
            }else if(command == 2){
                try {
                    main.queryBook();
                } catch (ErrorCodeException e) {
                    System.out.print(e.getMessage());
                } catch (NoExistBookException e) {
                    System.out.print(e.getMessage());
                }
            }
        }
    }

    public int command() throws ErrorCodeException{
        int result = 0;
        System.out.println("输入查询命令：1-按照图书名称查询，2-按照图书序列号查询。");
        Scanner input = new Scanner(System.in);
        String num = input.next().trim();
        if(num.equals("1")){
            result = 1;
        }else if (num.equals("2")){
            result = 2;
        }else {
            throw new ErrorCodeException("命令输入错误！请根据提示输入数字命令！\n");
        }
        return result;
    }

    public void noExistBook() throws NoExistBookException{
        System.out.println("请输入图书名称:");
        Scanner input = new Scanner(System.in);
        String bookName = input.next().trim();
        boolean flag = false;
        for(Book book:books){
            if(book.getBookName().equals(bookName)){
                System.out.println("book:"+book.getBookName());
                flag = true;
                break;
            }
        }
        if(!flag){
            throw new NoExistBookException("图书不存在！\n");
        }
    }

    public void queryBook() throws ErrorCodeException,NoExistBookException{
        System.out.println("请输入图书序号：");
        Scanner input = new Scanner(System.in);
        int serialNum = 0;
        boolean flag = false;
        try {
            serialNum = input.nextInt();
        } catch (Exception e) {
            throw new ErrorCodeException("请输入合法的数字\n");
        }
        for(Book book:books){
            if(book.getBookSerialNum() == serialNum){
                System.out.println("book:"+book.getBookName());
                flag = true;
                break;
            }
        }
        if(!flag){
            throw new NoExistBookException("图书不存在\n");
        }
    }

}
