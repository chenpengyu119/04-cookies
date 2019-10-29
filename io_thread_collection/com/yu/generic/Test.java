package com.yu.generic;

import java.util.ArrayList;
import java.util.List;

public class Test {

    //注意：定义带类型参数的方法，其主要目的是为了表达多个参数以及返回值之间的关系。
  //例如本例子中T和S的继承关系， 返回值的类型和第一个类型参数的值相同。

    public void testDemo(List<?> s){
        for (Object obj: s) {
            System.out.println("我的类型是：" + obj.getClass().getName());
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        Dog dog = new Dog();
        Animal a0 = new Animal();
        List<Animal> list = new ArrayList<Animal>();
        list.add(dog);
        list.add(a0);
       test.testDemo(list);


    }
}
