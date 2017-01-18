package com.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by admin on 2016/10/30.
 * Set
 */
public class SetTest {

    public static void main(String[] args){
        Map map = new HashMap();
        //添加（无序）
        map.put("name","jack");
        map.put("age",16);
        map.put("age1",17);
        map.put("age2",18);
        map.put("age4",19);
        map.put("age5",20);
        //删除
        map.remove("name");
        //keySet()得到Map所有的键
        Set set = map.keySet();
        for (Object o : set) {
            System.out.println(map.get(o));;
        }
        //keySet()得到Map的键值对
        Set<Map.Entry> set2 = map.entrySet();
        for (Map.Entry o : set2) {
            System.out.println(o.getValue());
        }
        System.out.print(map.containsKey("age1"));
        System.out.print(map.containsValue(16));
    }

}
