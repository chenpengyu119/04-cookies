package com.yu.testhashmap;

import java.util.*;

/**
 * Map转Set
 * Set转Map
 */
public class TestChangeHash {

    private HashMap<Course,String> map ;

    private HashSet<Course> set;

    public TestChangeHash() {
        this.map = new HashMap<>();
        map.put(new Course("1", "english"), "english");
        map.put(new Course("2", "math"), "math");
        this.set = new HashSet<>();
    }

    private void changeMapToSet(){
        map = new HashMap<>();

        Set<Course> keys = map.keySet();
        keys.forEach(k->set.add(k));
    }

    private void changeSetToMap(){
        set.forEach(v->map.put(v, v.name));
    }

    public static void main(String[] args) {

        TestChangeHash tester = new TestChangeHash();
        System.out.println("set.size():"+tester.set.size());
        tester.changeMapToSet();
        tester.set.forEach(v-> System.out.print(v.name+"\t"));
        System.out.println("\n--------------------------");
        tester.map = new HashMap<>();
        System.out.println("map.size()"+tester.map.size());
        tester.changeSetToMap();
        tester.map.forEach((k,v)-> System.out.print(v+"\t"));

        TreeMap treeMap = new TreeMap();
        treeMap.put(1, 2);

    }




}
