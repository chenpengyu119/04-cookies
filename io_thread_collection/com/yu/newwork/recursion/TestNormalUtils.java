package com.yu.newwork.recursion;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.Math.random;

/**
 * 常用工具类使用
 * @author pengyu
 */
public class TestNormalUtils {

    public static void main(String[] args) {

        // String转int
        Integer.parseInt("13");

        // 成员方法intValue
        int value = 12;
        Integer integer = new Integer(value);
        value = integer.intValue();

        // 日期类
        String pattern = "yyyy-MM-dd hh:mm:ss.SSS";
        DateFormat format = new SimpleDateFormat(pattern);
        Date date1 = new Date();
        System.out.println(date1);
        // 获取毫秒值
        System.out.println(date1.getTime());
        System.out.println(format.format(date1));

        Timestamp timestamp = new Timestamp(date1.getTime());
        System.out.println(timestamp);

        Calendar calendar = new GregorianCalendar();
        calendar.getTime();

        // 将字符串解析为Date
        String string = "2019-1-1 10:10:10.123";
        Date date2 = null;
        try {
            date2 = format.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 日期转字符串并格式化
        System.out.println(format.format(date2));

        // Math
        System.out.println((int)(random()*31+30));
        int[] arr = new int[50];
        for (int i = 0; i < 50; i++) {
            arr[i] = (int)(random()*31+30);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(" 1 2 3   ".trim());
        System.out.println("hamburger".substring(4, 8));

        System.out.println("--------------------***********************");
        String s2 = "a";
        String s = "a"+"b"+"c";

        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        mb_operate(a, b);
        System.out.println(b);
        System.out.println(a + "." + b);

        String s1= new String("pb_java_OOP_T5");
        s2 = s1.substring(s1.lastIndexOf("_"));
        System.out.println("s2="+s2);

        StringBuffer bnf = new StringBuffer();
        bnf.append("111");
        System.out.println(bnf.toString());

        System.out.println("**************************************");

        StringBuffer sbf = new StringBuffer("java");
        StringBuffer sbf1 = sbf.append(",C#");  //java,C#
        String sbf2 = sbf + ",C#";  //java,C#
        System.out.print(sbf.equals(sbf1));     //t
        System.out.println("sbf2:"+sbf2.toString());
        System.out.println(sbf2.equals(sbf));   //f



        String str = new String("good");
        char[] ch = { 'a', 'b', 'c' };
        str.toCharArray();

        change(str, ch);
        System.out.print(str + "and");
        System.out.print(ch);

        Scanner scanner = new Scanner(System.in);
        System.out.println("ccc:");
        scanner.next();

        List<String> list=new ArrayList<String>();
        list.add("str1");
        list.add(2, "str2");
        String s12=list.get(1);
        System.out.println(":"+s12);



    }

    public static void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'g';
    }


    static void mb_operate(StringBuffer x, StringBuffer y) {
        x.append(y);
        System.out.println("x:"+x);  // AB
        // 改变了y的指向
        y = x;
        System.out.println(y);
    }

}
