package com.yu.car;

/**
 * 出租车
 */
public class Taxi extends Vehicle{
    // 出租车公司
    private String taxiCompany;

    // 构造方法
    public Taxi(String type, String licensePlate, String taxiCompany) {
        super(type, licensePlate);
        this.taxiCompany = taxiCompany;
    }
    // 无参
    public Taxi() {
    }

    public String getTaxiCompany() {
        return taxiCompany;
    }

    public void setTaxiCompany(String taxiCompany) {
        this.taxiCompany = taxiCompany;
    }

    // 启动
    @Override
    public void start() {
        System.out.println("乘客您好\n我是"+taxiCompany+"的，我的车牌是"+licensePlate+
                ",您要去哪里？");
    }

    // 停止
    @Override
    public void stop() {
        System.out.println("目的地已经到了，请您付费下车，欢迎再次乘坐");
    }


}
