package com.yu.enumerationdemo;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author pengyu
 */
class Cat2{
    private int catNum;

    public Cat2(int catNum) {
        this.catNum = catNum;
    }
    public void print(){
        System.out.println("Cat Number "+catNum);
    }
}

class Dog2{
    private int dogNum;

    public Dog2(int dogNum) {
        this.dogNum = dogNum;
    }
    public void print(){
        System.out.println("Dog Number "+dogNum);
    }
}

public class  CatsAndDogs {
    public static void main(String[] args) {

        Vector cats = new Vector();
        for (int i=0;i<7;i++){
            cats.addElement(new Cat2(i));
        }
        cats.addElement(new Dog2(7));

        for (Enumeration e = cats.elements();e.hasMoreElements();){
            Object obj = e.nextElement();
            if (obj instanceof Cat2){
                ((Cat2) obj).print();
            }else  {
                ((Dog2) obj).print();
            }
        }
    }

}
