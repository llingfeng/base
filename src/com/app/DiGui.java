package com.app;import java.text.DecimalFormat;

/**
 * Created by admin on 2016/11/18.
 * 三、数列求和
 * 编写程序，输入一个正整数n，求下列算式的值。要求定义和调用函数fact(k)计算k的阶乘，函数返回值的类型是double。
 * 1+1/2!+ .... +1/n!
 * 输出保留5位小数。
 * 下面是一些合理的表达式的例子：
 * Input         5
 * Output      1.71667
 */
public class DiGui {

    public static void main(String[] args) {
        int k = 5;
        double value = fact(k);
        System.out.println(value);
    }

    /**
     * 求和
     * @param k
     * @return
     */
    public static double fact(int k) {
        if (k == 0) {
            return 0;
        }
        double tempNum = jieCen(k);//阶层的值
        double sum = tempNum + fact(--k);
        DecimalFormat df = new DecimalFormat(".#####");
        String st = df.format(sum);
        return Double.valueOf(st);
    }

    /**
     * 求阶层
     * @param k
     * @return
     */
    public static double jieCen(int k) {
        if (k == 0) {
            return 1;
        }
        return 1.0 / k * jieCen(--k);
    }
}
