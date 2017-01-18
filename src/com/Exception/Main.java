package com.Exception;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by admin on 2016/8/29.
 */
public class Main {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("请输入第一个数：");
            int num1 = input.nextInt();
            System.out.print("请输入第二个数：");
            int num2 = input.nextInt();
            System.out.print("两数相除的结果："+num1/num2);
        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.print("输入的数字格式不对"+e);
        }catch (ArithmeticException e){
            System.out.print("除数不能为零"+e);
        }catch (Exception e){
            System.out.print("未知错误"+e);
        }
    }
}
