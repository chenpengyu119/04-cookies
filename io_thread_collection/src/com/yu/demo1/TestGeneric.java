package com.yu.demo1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试泛型
 */
public class TestGeneric {

    public static void main(String[] args) {

        MyCollection<String> mc = new MyCollection<String>();
        mc.set("集合", 1);
        String s = mc.get(1);
        System.out.println(s);

        List list = new ArrayList();
        Map map = new HashMap();
    }
}


/**
 * 自定义泛型
 * @param <E>
 */
class MyCollection<E>{
    Object[] objs = new Object[5];

    public E get(int index) {
        return (E) objs[index];
    }

    public void set(E e,int index) {
        objs[index]=e;
    }
}
