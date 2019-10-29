package com.yu.demo1;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class TestList {

    public static void main(String[] args) {

        List list1 = new ArrayList();
        // 只能顺序添加
        // list1.add(1, 124);
        list1.add(0,124 );
        boolean isSucess = list1.remove(Integer.valueOf(124));
        System.out.println(isSucess);

        for(int i=0;i<10;i++){
            list1.add(i, i+1);
        }

        System.out.println(list1);

        // 只能先正向遍历一遍，才能逆向遍历
        ListIterator iterator = list1.listIterator();
        for (;iterator.hasNext();){
            iterator.next();

        }
        for (;iterator.hasPrevious();){
            System.out.println(iterator.previous());
        }

    }
}
