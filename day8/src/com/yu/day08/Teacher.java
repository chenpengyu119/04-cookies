package com.yu.day08;

import src.com.yu.day08.Person;

public class Teacher extends Person {

    String yearsOfTeach;

    public String getYearsOfTeach() {
        return yearsOfTeach;
    }

    public void setYearsOfTeach(String yearsOfTeach) {
        this.yearsOfTeach = yearsOfTeach;
    }

    public Teacher(String name, int age, String gender, String yearsOfTeach) {
        super(name, age, gender);
        this.yearsOfTeach = yearsOfTeach;
    }

    @Override
    public void show() {
        super.show();
        System.out.println("教龄："+yearsOfTeach);
    }
}
