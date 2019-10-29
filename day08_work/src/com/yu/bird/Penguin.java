package com.yu.bird;

/**
 * 企鹅
 */
public class Penguin extends Bird{
    public Penguin() {
    }

    public Penguin(String name, String color) {
        super(name, color);
    }

    @Override
    public void fly() {
        System.out.println("我是企鹅"+name+",我太胖了，所以不会飞");
    }

    @Override
    public void eat() {
        System.out.println("我喜欢吃<。)#)))<=");
    }

    public void swim(){
        System.out.println("虽然我很胖，但我比<。)#)))<=游得快");
    }
}
