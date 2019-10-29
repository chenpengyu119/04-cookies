package com.yu.testhashmap;

import src.com.yu.day08.Person;

import java.text.CollationKey;
import java.text.Collator;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @author pengyu
 */
public class MapTest2 {

    public TreeMap<String, Course> course;

    public MapTest2() {
        this.course = new TreeMap<>();
    }

    public void testAdd(){
        course.put("1", new Course("1", "语文"));
        course.put("2", new Course("2", "数学"));
    }

    public void testTraverseByKey(){
        // 获取key集合
        Set<String> keys = course.keySet();
        keys.forEach(key -> System.out.print(course.get(key).name+"\t"));
    }
    public void testTraverseByValue(){
        // 获取value集合
        Collection<Course> values = course.values();
        values.forEach(v -> System.out.print(v.id+":"+v.name+"\t"));
    }

    public static void main(String[] args) {

        MapTest2 test = new MapTest2();
        test.course = new TreeMap<String, Course>(new Comparator<String>() {
            @Override
            public int compare(String o1, String  o2) {
                // 解决中文不排序
                Collator collator = Collator.getInstance(Locale.CHINA);
                CollationKey ck1 = collator.getCollationKey(o1);
                CollationKey ck2 = collator.getCollationKey(o2);

                return  ck1.compareTo(ck2);
            }
        });

        test.testAdd();
        test.testTraverseByKey();
        System.out.println();
        test.testTraverseByValue();
    }
}
