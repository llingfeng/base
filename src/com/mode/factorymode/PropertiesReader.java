package com.mode.factorymode;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by admin on 2016/12/8.
 */
//读取配置文件,单例模式
public class PropertiesReader {
    private static Map<String,String> map = null;
    private PropertiesReader(){}

    public static Map<String,String> getProperties(){
        if(map == null){
            map = new HashMap<>();
            Properties properties = new Properties();
//        InputStream in = getClass().getResourceAsStream("type.properties");
            InputStream in = PropertiesReader.class.getResourceAsStream("type.properties");
            try {
                properties.load(in);
                Enumeration en = properties.propertyNames();
                while (en.hasMoreElements()){
                    String key = (String) en.nextElement();
                    String value = properties.getProperty(key);
                    map.put(key,value);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return map;
    }
}
