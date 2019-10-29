package com.yu.car;

/**
 * 汽车测试类
 */
public class TestVehicle {

    final static String line = "=================================================";
    public static void main(String[] args) {
        // 父类
        Vehicle vehicle = new Vehicle();
        // 启动
        vehicle.start();
        // 停止
        vehicle.stop();

        System.out.println(line);

        // 创建私家车类对象
        PrivateCar privateCar = new PrivateCar();
        privateCar.setName("武大郎");
        privateCar.start();
        privateCar.stop();
        // 分割线
        System.out.println(line);

        // 出租车类对象
        Taxi taxi = new Taxi();
        taxi.setTaxiCompany("景顺出租车公司");
        taxi.setLicensePlate("京B123");

        taxi.start();
        taxi.stop();
    }
}
