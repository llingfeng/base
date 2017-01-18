package com.imooc.action;

import com.imooc.dao.GodnessDao;

/**
 * Created by admin on 2016/8/31.
 */
public class GodnessAction {

    public static void main(String[] args) throws Exception{
        GodnessDao godnessDao = new GodnessDao();
        Integer count = godnessDao.queryGodnessCount();
        System.out.println("godness数量："+count);
        /*List<Godness> godnessList = godnessDao.queryGodnessProcedureParam("溪");
        for (Godness g : godnessList) {
            System.out.println("id:"+g.getId()+",name:"+g.getUserName());
        }*/
        /*Godness godness = new Godness();
        godness.setUserName("小萌");
        godness.setAge(20);
        godness.setSex(0);
        godness.setBirthday(new Date());
        godness.setEmail("这是email");
        godnessDao.addGodness(godness);
        List<Godness> godnessList = godnessDao.queryGodness();
        for (Godness g : godnessList) {
            System.out.println("id:"+g.getId()+",name:"+g.getUserName());
        }*/
        /*List<Map<String,Object>> mapList = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("name","user_name");
        map.put("rela","like");
        map.put("value","'%萌%'");
        mapList.add(map);
        List<Godness> godnessList = godnessDao.queryGodnessByParams(mapList);
        for (Godness godness : godnessList) {
            System.out.println(godness);
        }*/
    }
}


