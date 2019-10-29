package com.yu.testconnections;

import java.util.HashMap;
import java.util.TreeMap;

public class WorkDay15 {
    private HashMap<Integer,Book> hashMap;

    private TreeMap<Integer,Book> treeMap;

    public WorkDay15() {
        hashMap = new HashMap<>();
        treeMap = new TreeMap<>();
    }

    public static void main(String[] args) {
        WorkDay15 tester = new WorkDay15();

        Book book1 = new Book(003, "thinking in java", 98);
        Book book2 = new Book(001, "effective Java", 56);
        Book book3 = new Book(002, "SpringBoot Excising", 80);
        Book book4 = new Book(002, "SpringBoot Excising2", 90);

        tester.hashMap.put(book1.getId(),book1);
        tester.hashMap.put(book2.getId(), book2);
        tester.hashMap.put(book3.getId(), book3);
        tester.hashMap.put(book4.getId(), book4);

        tester.treeMap.putAll(tester.hashMap);

        System.out.print("hashMap:");
        tester.hashMap.forEach((k,v)-> System.out.print("\tkey:"+k+"--"+v.getName()+"--"+v.getPrice()));
        System.out.println("\n-------------------------------");
        System.out.print("treeMap:");
        tester.treeMap.forEach((k,v)-> System.out.print("\tkey:"+k+"--"+v.getName()+"--"+v.getPrice()));




    }
}
