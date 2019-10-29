package com.yu.entity;

public class Student {

    private int StuNo;
    private String name;

    public Student() {
    }

    public Student(int stuNo, String name) {
        StuNo = stuNo;
        this.name = name;
    }

    public int getStuNo() {
        return StuNo;
    }

    public void setStuNo(int stuNo) {
        StuNo = stuNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
