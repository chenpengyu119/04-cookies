package com.yu.testgeneralclass;

/**
 * 学习double类
 */
public class TestDouble {
    public static void main(String[] args) {
        System.out.println(Double.MAX_VALUE);

        System.out.println(Double.MIN_VALUE);
        System.out.println((Double.MIN_VALUE-1)==Double.MAX_VALUE);

        // 构造方法
        String s;
        Double double1 = Double.valueOf(1.0);
        try {
            Double double2 = Double.valueOf("a");
        }catch (NumberFormatException e){
            System.out.println("类型不正确");
        }

        //基本转包装
        Double d1 = Double.valueOf(1.0);
        // 包装类转基本类型
        double d2 = d1.doubleValue();

        // 基本类型转String
        String string = String.valueOf(d2);
        // String 转基本类型
        double d3 = Double.parseDouble(string);

        // 包装类转基本类型
        double d4 = d1.doubleValue();
        // 基本类型转包装类
        Double d5 = Double.valueOf(2.0);





    }
}
