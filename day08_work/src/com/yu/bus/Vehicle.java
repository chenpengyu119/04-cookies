package com.yu.bus;

/**
 * 父类
 */
public class Vehicle {
    // 车牌号
    public String licensePlate;
    // 车型
    public String type;
    // 颜色
    public String color;
    // 日租金
    public double dailyRent;
    // 租车人
    public String name;

    public Vehicle() {
    }

    public Vehicle(String licensePlate, String type, String color, double dailyRent, String name) {
        this.licensePlate = licensePlate;
        this.type = type;
        this.color = color;
        this.dailyRent = dailyRent;
        this.name = name;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getDailyRent() {
        return dailyRent;
    }

    public void setDailyRent(double dailyRent) {
        this.dailyRent = dailyRent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 租赁
    public void calcRent(int days){

    }



}
