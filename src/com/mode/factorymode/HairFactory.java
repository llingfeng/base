package com.mode.factorymode;

import java.util.Map;

/**
 * Created by admin on 2016/12/8.
 */
public class HairFactory {

    /**
     * 根据类型创建对象
     * @param key
     * @return
     */
    public HairInterface getHair(String key){
        if("left".equals(key)){
            return new LeftHair();
        }
        if("right".equals(key)){
            return new RightHair();
        }
        return null;
    }

    /**
     * 根据类的路径名获取对象
     * @param className
     * @return
     */
    public HairInterface getHairByClass(String className){
        HairInterface hairInterface = null;
        try {
            hairInterface = (HairInterface) Class.forName(className).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return hairInterface;
    }

    /**
     * 根据类名获取对象
     * @param key
     * @return
     */
    public HairInterface getHairByName(String key){
        Map<String,String> properties = PropertiesReader.getProperties();
        Map<String,String> properties3 = PropertiesReader.getProperties();
        System.out.println(properties == properties3);
        HairInterface hairInterface = null;
        try {
            hairInterface = (HairInterface) Class.forName(properties.get(key)).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return hairInterface;
    }
}
