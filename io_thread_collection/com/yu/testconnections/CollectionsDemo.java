package com.yu.testconnections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.List;

/**
 * 测试集合工具类Collections
 */
public class CollectionsDemo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        // 赋值
       /* list.add(3);
        list.add(5);
        list.add(7);
        list.add(9);
        list.add(11);*/
       Collections.addAll(list, 3,5,7,9,11);

        System.out.print("初始顺序：");
        list.forEach(v-> System.out.print(v+"\t"));

        List newList = new ArrayList();
        // 容易越界
        Collections.addAll(newList, 1,1,1,1,1,1,1,1,1);
        Collections.copy(newList, list);
        System.out.println("新集合:"+newList);

        // 打乱顺序
        Collections.shuffle(list);
        System.out.print("\n乱序集合：");
        list.forEach(v-> System.out.print(v+"\t"));

        // 第一个和最后一个交换
        Collections.swap(list, 0, list.size()-1);
        System.out.print("\n交换第一个和最后一个：");
        list.forEach(v-> System.out.print(v+"\t"));

        // 按自然升序
        Collections.sort(list);
        System.out.print("\n自然排序：");
        list.forEach(v-> System.out.print(v+"\t"));

        // 二分查找
        System.out.println("\n查找数值7的位置"+ Collections.binarySearch(list, 7));

        List<Integer> synchronizedList = Collections.synchronizedList(list);

    }

}
