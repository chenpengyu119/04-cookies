package com.yu.threadtutorial.testproductconsumer;

/**
 * 商品
 * @author pengyu
 */
public class Goods {
    private String name;
    private String brand;
    public boolean flag;


    public Goods() {
    }

    public Goods(String name, String brand) {
        this.name = name;
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
