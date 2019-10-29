package com.yu.testObject;

import java.util.Objects;

public class Person {
    private String name;
    private int num;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", num=" + num +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return num == person.num &&
                name.equals(person.name);
    }



    @Override
    public int hashCode() {
        return Objects.hash(name, num);
    }

    public static void main(String[] args) {
        Objects.equals(new Person().num, new Person().name);
    }
}
