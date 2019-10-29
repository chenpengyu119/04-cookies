package com.yu.bus;

/**
 * 小汽车
 */
public class Car extends Vehicle{

    public Car() {
    }

    public Car(String licensePlate, String type, String color, double dailyRent, String name) {
        super(licensePlate, type, color, dailyRent, name);
    }

    @Override
    public void calcRent(int days) {
        double rent = 10*dailyRent+(days-10)*dailyRent*0.1;;
        System.out.println("租赁信息：\n"+"车牌号："+licensePlate
                +"\n车型："+type+
                "\n颜色"+color+"\n租车人"+name+"应付金额："+rent);
    }
}
