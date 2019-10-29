package com.yu.factory;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("画什么  Circle");
        String str= scanner.next();
        Shape s = ShapeFactory.create(str);
        /*s.draw();*/
        ShapeFactory.show(s);
    }
}
