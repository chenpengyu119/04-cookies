package com.yu.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class DemoCalendar {


    public static void main(String[] args) throws ParseException {

        Scanner input = new Scanner(System.in);
        System.out.println("日期:yyyy-MM-dd");
        String inDate = input.next();
        // 转日期
        Calendar calendar = new GregorianCalendar();

        // String -> Date parse
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(inDate);
        calendar.setTime(date);


        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println("日\t"+"一\t"+"二\t"+"三\t"+"四\t"+"五\t"+"六");

        // 设置日期为1号
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        // 判断星期
        int week = calendar.get(Calendar.DAY_OF_WEEK);
        // 空格打印
        for (int i=0;i<week-1;i++){
            System.out.print("\t");
        }

        for (int i=1;i<=maxDay;i++){
            System.out.print(i+"\t");
            // 周六换行
            System.out.print(calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY?"\n":"");
            // 日期加1
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

    }

}
