package com.yu.finaltest;

public class TestFinal {
    public static void main(String[] args) {
        int a ;
        a=10;
        final Dog dog = new Dog("小白", "藏獒");
        //dog = new Dog(); // can not be modified
        dog.setNickName("小花");

    }

}

class Dog{
    String nickName;
    String type;

    public Dog() {
    }

    public Dog(String nickName, String type) {
        this.nickName = nickName;
        this.type = type;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
