package com.yu.testgeneralclass;

/**
 * 常用类
 * valueOf: 可以把其他类型转成自己的类型
 * parseInt: 由包装类提供的String和基本类型之间的桥梁
 */
public class Demo1 {
    public static void main(String[] args) {

        // 基本转包装类
        Integer integer = Integer.valueOf(12);
        // 包装类转基本类型
        int i = integer.intValue();

        // 基本转String
        // 1. 字符串连接
        String string = ""+i;
        // 2. String.valueOf
        String string2 = String.valueOf(i);
        // String 转基本数据类型
        int j = Integer.parseInt(string);

        // 包装类转String  toString、String.valueOf(Object o)
        String string3 = integer.toString();
        String string4 = String.valueOf(integer);
        // String转包装类
        Integer integer1 = Integer.valueOf(string3);


        // Number的属性
        int i2 = Integer.MAX_VALUE;
        // 最小值减一是最大值
        System.out.println(i2==Integer.MIN_VALUE-1);



    }
}
