package com.yu.car;

/**
 * 私家车
 */
public class PrivateCar extends Vehicle{

    // 车主姓名
    private String name;

    public PrivateCar() {
    }

    public PrivateCar(String type, String licensePlate, String name) {
        super(type, licensePlate);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 启动
    @Override
    public void start() {
        System.out.println("我是"+name+",我的汽车我做主");
    }

    // 停止
    @Override
    public void stop() {
        System.out.println("目的地到了，我们去玩吧");
    }
}
