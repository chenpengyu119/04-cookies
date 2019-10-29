package com.yu.bus;

import java.util.Scanner;

/**
 * 出租公司车辆管理系统
 */
public class TestVehicle {

    final static String line = "=================================================";
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        System.out.println("请输入租车人姓名：");
        String name = input.next();
        System.out.println("请输入租赁天数：");
        int days = input.nextInt();

        // 卡车
        Truck truck = new Truck("京D1111", "东风", "蓝色",
                20.38, name, 500);

        truck.calcRent(days);

        System.out.println(line);

        System.out.println("请输入租车人姓名：");
        name = input.next();
        System.out.println("请输入租赁天数：");
        days = input.nextInt();

        // 私人小汽车
        Car car = new Car("京R00000", "奥迪A6", "黑色",
                190.9, name);

        car.calcRent(days);
    }





}

/**
 * x*10+5*0.1*x*500=5300   260x=5300
 * 10*x+10*0.1*x=2100
 */

