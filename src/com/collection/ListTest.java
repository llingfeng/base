package com.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by admin on 2016/10/30.
 */
public class ListTest {

    public static void main(String[] args){
        List<String> list = new ArrayList<String>();
        String[] strs = new String[]{"语文","英语","数学"};
        //添加值
        list.add("手机");
        list.add(1,"呵呵");
        list.addAll(Arrays.asList(strs));
        //修改
        list.set(1,"哈哈");
        //输出（for循环）
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        //输出(迭代)
        Iterator it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        //删除
        list.remove("手机");
        list.remove(1);
        list.removeAll(Arrays.asList(new String[]{"数学","英语"}));
        //输出（foreach）
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(list.indexOf("哈哈"));;
    }
}
