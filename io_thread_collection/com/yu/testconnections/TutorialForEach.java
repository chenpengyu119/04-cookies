package com.yu.testconnections;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * JDK1.8新增方法
 * Iterable中有个forEach方法
 * 参数可以是lamda表达式或者方法引用
 */
public class TutorialForEach {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();

        names.add("Bob");
        names.add("Smith");
        String str = "";
        names.forEach(cc-> System.out.println(cc));
        names.forEach(System.out::println);
    }
}
