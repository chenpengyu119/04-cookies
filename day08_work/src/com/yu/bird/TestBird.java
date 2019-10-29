package com.yu.bird;

import java.util.Scanner;

public class TestBird {
    final static String line = "=================================================";
    public static void main(String[] args) {

     /*   String string = "com.yu.bird.";*/
       /* Bird bird = new Bird("鸟", "");
        bird.fly();
        bird.eat();
        System.out.println(line);*/
     /*   Scanner scanner = new Scanner(System.in);
        System.out.println("Penguin  Sparrow");
        String type = scanner.next();
        BirdFactory.createBird(string+type).fly();
*/


        Bird sparrow = new Sparrow("嘟嘟", "");
        sparrow.fly();
        sparrow.eat();

        System.out.println(line);

        Penguin penguin = new Penguin("QQ" , "");
        penguin.fly();
        penguin.eat();
        penguin.swim();


     /*   System.out.println(sparrow instanceof Bird);
        System.out.println(sparrow instanceof Object);
        System.out.println(sparrow instanceof Penguin);*/
        System.out.println(sparrow instanceof Penguin);

        System.out.println();

    }
}
