package com.yu.demo1;

import java.util.Deque;
import java.util.LinkedList;

public class TestDeque {
    public static void main(String[] args) {

        Deque<String> deque = new LinkedList<String>();
        deque.offerFirst("1");
        deque.addFirst("2");
        System.out.println(deque);
    }
}
