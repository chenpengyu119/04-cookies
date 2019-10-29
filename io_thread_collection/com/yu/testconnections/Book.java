package com.yu.testconnections;

import java.util.Objects;

public class Book {
    // 书号
    private int id;
    // 书名
    private String name;
    // 价格
    private double price;

    public Book() {
    }

    public Book(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    // 必须重写hashCode和equals，因为底层是hash表，会调用比较方法去重

}
