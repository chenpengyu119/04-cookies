package com.yu.bird;

/**
 * 鸟
 * @author pengyuchen
 * @date 2016/06/06
 */
public class Bird {
    public String name;
    public String color;

    public Bird(String name, String color) {
        this.name = name;
        this.color = color;
    }
    public Bird() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void fly(){
        System.out.println("我是"+name+",我会飞");
    }

    public void eat(){
        System.out.println("我是"+name+",我吃的不是饭是寂寞");
    }

}
