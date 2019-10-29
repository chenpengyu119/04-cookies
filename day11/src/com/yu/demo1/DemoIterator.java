package com.yu.demo1;

import javax.swing.text.html.parser.Entity;
import java.util.*;

/**
 * 测试迭代器遍历List、Map、Set
 * List继承Collection,Collection继承类Iterable接口,Iterable帮助得到Iterator对象
 */
public class DemoIterator{
    public static void main(String[] args) {

    }

    private static void testIteratorList(){
        // List<String> list = new ArrayList<>();
        Set<String> list = new HashSet<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        //使用iterator遍历List ，和遍历Set一样
        // 先获得迭代器对象，然后通过hasNext判断
        for (Iterator<String> iterator=list.iterator();iterator.hasNext();){
            // next既返回当前元素，又移动指针指向下一个元素
            String temp = iterator.next();
            System.out.println(temp);
        }

    }
    /**
     * 遍历map
     */
    private static void testIteratorMap(){
        // List<String> list = new ArrayList<>();
        Map<Integer,String> list = new HashMap<>();
        list.put(100,"aaa");
        list.put(200,"bbb");
        list.put(300,"ccc");

        Set<Map.Entry<Integer,String>> ss = list.entrySet();
        // 先获得迭代器对象，然后通过hasNext判断
        for (Iterator<Map.Entry<Integer,String>> iterator=ss.iterator();iterator.hasNext();){
            // next既返回当前元素，又移动指针指向下一个元素
            Map.Entry<Integer,String> temp = iterator.next();
            System.out.println(temp.getKey()+":"+temp.getValue());
        }

    }


}
