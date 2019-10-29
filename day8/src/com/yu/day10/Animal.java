package com.yu.day10;

public abstract class Animal {
    abstract void shout();

}
class Dog extends Animal{

    @Override
    void shout() {
        System.out.println("汪汪");
    }
}

class Cat extends Animal{

    @Override
    void shout() {
        System.out.println("喵喵");
    }
}

class Flog extends Animal{
    @Override
    void shout() {
        System.out.println("呱呱呱");
    }
}

class AnimalBiz {
    void show(Animal animal){
        animal.shout();
    }
}

