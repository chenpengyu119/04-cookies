package com.yu.testiooperator;

import java.io.Serializable;

/**
 * @author pengyu
 */
public class Student implements Serializable ,Comparable{

    private static final Long serialVersionUID = 123L;
    /**
     * 学号
     */
    private int stuNo;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int age ;

    public Student(int stuNo, String name, int age) {
        this.stuNo = stuNo;
        this.name = name;
        this.age = age;
    }

    public int getStuNo() {
        return stuNo;
    }

    public void setStuNo(int stuNo) {
        this.stuNo = stuNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNo=" + stuNo +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Student s = (Student)o;
        return this.stuNo-s.stuNo;
    }
}
