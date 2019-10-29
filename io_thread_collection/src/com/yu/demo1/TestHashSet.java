package src.com.yu.demo1;

import src.com.yu.day08.Person;


import java.util.HashSet;
import java.util.Iterator;

public class TestHashSet {

    public static void main(String[] args) {
        // 哈希set
        HashSet<String> set = new HashSet<String>();
        set.add("jack");
        set.add("and");
        set.add("rose");

        for (Iterator iterator=set.iterator();iterator.hasNext();){
            System.out.println(iterator.next());
        }

        System.out.println(set.size());
        System.out.println(set.remove("ad"));
        set.clear();
        System.out.println(set);

        HashSet<Person> set1 = new HashSet<>();
        Person p1 = new Person("zhangsan",20,"男");
        Person p2 = new Person("zhangsan",18,"女");
        System.out.println(""+set1.add(p1)+set1.add(p2));





    }
}
