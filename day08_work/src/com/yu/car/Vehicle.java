package com.yu.car;

/**
 * 汽车类
 */
public class Vehicle {
    // 车型
    String type;
    // 车牌
    String licensePlate;

    public Vehicle() {
    }
    // 构造方法
    public Vehicle(String type, String licensePlate) {
        // 车型
        this.type = type;
        // 车牌
        this.licensePlate = licensePlate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    // 启动
    public void start(){
        System.out.println("我是车，我启动");
    }
    // 停止
    public void stop(){
        System.out.println("我是车，我停止");
    }


}
