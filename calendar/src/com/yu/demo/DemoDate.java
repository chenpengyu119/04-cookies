package com.yu.demo;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DemoDate {
    public static void main(String[] args) {

        testDate();
    }


    /**
     * util.Date  /  sql.Date
     */
    static void testDate(){

        // 通过父类获取对象
        Date date1 = new Date();
        // 东八区时间
        System.out.println(date1);

        // 格林尼治
        TimeZone timeZone = TimeZone.getDefault();
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss SSS");
        format2.setTimeZone(TimeZone.getTimeZone("Europe/London"));
        System.out.println(format2.format(date1));

        System.out.println("过时:"+date1.toGMTString());

        DateFormat format = DateFormat.getDateInstance();
        System.out.println(format.format(date1));
        // 子类
        DateFormat format1 = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss SSS");
        System.out.println(format1.format(date1));

        //  sql.Date
        Date date0 = new Date();
        java.sql.Date date2 = new java.sql.Date(date0.getTime());
        // 2019-06-13
        System.out.println(date2);

        // time
        java.sql.Time time = new Time(date0.getTime());
        System.out.println(time);

        // timestamp
        java.sql.Timestamp timestamp = new Timestamp(date0.getTime());
        System.out.println(timestamp);



    }
}
