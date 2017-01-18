package com.app;

import java.util.Arrays;

/**
 * Created by admin on 2016/11/2.
 * 冒泡
 */
public class MaoPao {

    public static void main(String[] args) {
        int[] a = new int[]{2, 1, 4, 92, 5, 9, 123, 123, 124, 120};
        a = paiXu(a);
        System.out.println(Arrays.toString(a));
        print(5);
    }

    /**
     * 冒泡排序
     * @param a
     * @return
     */
    public static int[] paiXu(int[] a) {
        int k = a.length - 1;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k - i; j++) {
                if (a[j] > a[j + 1]) {
                    a[j] = a[j] ^ a[j + 1];
                    a[j + 1] = a[j] ^ a[j + 1];
                    a[j] = a[j] ^ a[j + 1];
                }
            }
        }
        return a;
    }

    /**
     * 打印金字塔
     * @param m
     */
    public static void print(int m) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 2 * (m - i - 1); j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i + 1; k++) {
                int num1 = (int) Math.pow(2, k);
                System.out.print(num1 + " ");
            }
            for (int p = 0; p < i; p++) {
                int num2 = (int) Math.pow(2, i - p - 1);
                System.out.print(num2 + " ");
            }
            System.out.println();
        }
    }
}
