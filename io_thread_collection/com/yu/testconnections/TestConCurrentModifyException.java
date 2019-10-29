package com.yu.testconnections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class TestConCurrentModifyException {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("java");
        list.add("hello");

        ListIterator iterator = list.listIterator();
        while (iterator.hasNext()){
            iterator.next();
            // iterator没有add方法，ListIterator增加了add方法，避免了并发修改异常
            iterator.add( "java2");
        }
        System.out.println(list);

       /* LinkedList<String> list1 = new LinkedList();
        list.add("1");
        ListIterator iterator1 = list1.listIterator();*/



    }
}
