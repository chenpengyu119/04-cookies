package com.yu.bus;

/**
 * 卡车
 */
public class Truck extends Vehicle{
    // 载重量
    private double load;

    public Truck() {
        super();
    }

    public Truck(String licensePlate, String type, String color, double dailyRent, String name, double load) {
        super(licensePlate, type, color, dailyRent, name);
        this.load = load;
    }

    public double getLoad() {
        return load;
    }

    public void setLoad(double load) {
        this.load = load;
    }

    @Override
    public void calcRent(int days) {
        double rent = 10*dailyRent+(days-10)*load*dailyRent*0.1;;
        System.out.println("租赁信息：\n"+"车牌号："+licensePlate
        +"\n车型："+type+
                "\n颜色"+color+"\n载重量："+load
                +"\n租车人"+name+"应付金额："+rent);
    }
}
