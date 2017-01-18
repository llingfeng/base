package com.app;import java.util.*;

/**
 * Created by admin on 2016/11/18.
 * 二、提取不重复的整数
 * 描述: 输入一个int型32位整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 运行时间限制: 10 Sec
 * 内存限制: 无限制
 * 输入: 整数，如9876673
 * 注意：
 * 1、整数最后的0，请忽略，例如：输入1750，输出：571
 * 2、负数，保留'-'在前面，例如：输入-175，输出：-571
 * 输出: 整数，如37689
 * 样例输入: 9876673
 * 样例输出: 37689
 */
public class ReverseInteger {

    public static void main(String[] args) {
        int num = 9876673;
        int newNum = dealRepeat(num);
        System.out.print(newNum);
    }

    /**
     * 处理重复数字
     * @param num
     * @return
     */
    public static int dealRepeat(int num) {
        String[] arr = String.valueOf(num).split("");
        List<String> list = Arrays.asList(arr);
        Collections.reverse(list);
        int index = 0;
        //去除末尾的0
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals("0")) {
                index = i;
                break;
            }
        }
        //创建集合存放新的数据
        List<String> newList = new ArrayList<>();
        for (int i = index; i < list.size(); i++) {
            if(list.get(i).equals("-")){
                newList.add(0,"-");
            }else {
                newList.add(list.get(i));
            }
        }
        //遍历集合去重
        List<String> dataList = new ArrayList<>();
        for (int i = 0; i < newList.size(); i++) {
            if (!dataList.contains(newList.get(i))) {
                dataList.add(newList.get(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String o : dataList) {
            sb.append(o);
        }
        return Integer.parseInt(sb.toString().equals("") ? "0" : sb.toString());
    }
}