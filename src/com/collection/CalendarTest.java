package com.collection;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by admin on 2016/10/28.
 */
public class CalendarTest {

    public static void main(String[] args) throws Exception {
        //年月日时分秒星期 （2016/10/30/14/48/45/1）
        //月份从0开始算起，星期日代表一周的第一天
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour2 = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        int week = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(calendar);
        System.out.println(year+"/"+month+"/"+day+"/"+hour2+"/"+minute+"/"+second+"/"+week);
        Date date = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(date);//日期转字符串（2016-10-30 14:56:18）
        Date date2 = simpleDateFormat.parse("2016-10-30 14:54:41");//字符串转Date（Sun Oct 30 14:54:41 CST 2016）
        System.out.println(time);
        System.out.println(date2);
    }
}
