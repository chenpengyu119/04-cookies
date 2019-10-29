package com.yu.bird;

/**
 * 麻雀
 */
public class Sparrow extends Bird{

    public Sparrow() {
    }

    public Sparrow(String name, String color) {
        super(name, color);
    }

    @Override
    public void fly() {
        System.out.println("我是麻雀"+name+"，我动作敏捷，飞的比火箭快");
    }

    @Override
    public void eat() {
        System.out.println("我不仅吃种子，也吃害虫！");
    }
}
