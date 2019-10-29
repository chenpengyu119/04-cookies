package com.yu.testcomparator;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Administrator
 */
public class TestComparabale {
    public static void main(String[] args) {
        Student[] students = {new Student(18, "zhangsan", "男"),
                new Student(30, "lisi", "男"),
        new Student(20, "wangwu", "女")
        };
        System.out.println("排序前："+ Arrays.toString(students));
        // 按年龄排序
        Arrays.sort(students);
        System.out.println("按年龄排序后："+ Arrays.toString(students));
        System.out.println("-------------------------------------------");
        Comparator comparator1 = new TestComparator();
        Arrays.sort(students,comparator1);
        System.out.println("按姓名排序后："+ Arrays.toString(students));

    }
}

class Student implements Comparable{

    private int age;
    private String name;
    private String gender;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Student() {
    }

    Student(int age, String name, String gender) {
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        // 向下转型
        Student student = (Student)o;
        return this.age-student.age;
    }
}
