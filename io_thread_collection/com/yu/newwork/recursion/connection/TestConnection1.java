package com.yu.newwork.recursion.connection;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * @author pengyu
 */
public class TestConnection1 {
    public static void main(String[] args) {
        test1();

        testVector();

    }

    static void test1(){

        Map<String, String> map = new HashMap<String, String>();
        String s = "code";
        map.put(s, "1");
        map.put(s, "2");
        System.out.println(map.size());

    }

    static void testVector(){
        Vector v = new Vector();
        int i = 1;
        v.addElement(i);

        System.out.println(v.get(0));
    }

}
