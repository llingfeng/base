package com.io;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by admin on 2017/1/10.
 */
public class Test {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] num = new int[n][n];
        int[][] cal = new int[n][n];
        int i = 0;
        while (i < n) {
            int j = 0;
            while (j <= i) {
                num[i][j] = sc.nextInt();
                j++;
            }
            i++;
        }
        for (int j = 0; j < n; j++) {
            cal[n-1][j]=num[n-1][j];
        }
        for (int j = n - 2; j >= 0; j--) {
            for (int k = n - 2; k >= 0; k--) {
                cal[j][k]=Math.max(cal[j+1][k],cal[j+1][k+1])+num[j][k];
            }
        }
        System.out.println(cal[0][0]);
    }
}
