package com.yu.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class DemoCollection {

    public static void main(String[] args) {

        Collection collection = new ArrayList();
        collection.add("hello");
        collection.add(219);
        collection.add(true);
        if ((collection!=null)) {
            // 长度
            System.out.println("长度：" + collection.size());
            // 判断空
            System.out.println("是否为空:" +collection.isEmpty());
            // 查找
            System.out.println(collection.contains(219));
            // 删除
            collection.remove("hello");
            System.out.println(collection);
            // 全部删除
            collection.clear();
            System.out.println(collection);
            Collection collection1 = new ArrayList();
            collection1.add("background");
            collection1.add("red");
            collection1.add("black");
            collection1.add("tree");
            collection.addAll(collection1);

            System.out.println(collection);

            // 遍历
            for (Iterator iterator=collection.iterator();iterator.hasNext();){
                System.out.println(iterator.next());
            }


        }
    }
}
