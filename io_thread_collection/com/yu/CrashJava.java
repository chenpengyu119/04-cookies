package com.yu;

import java.util.Vector;

/**
 * @author pengyu
 */
public class CrashJava {
    @Override
    public String toString() {
        return "CrashJava Address:"+super.toString()+"\n";
    }

    public static void main(String[] args) {
/*        Vector v = new Vector();
        for (int i=0;i<10;i++){
            v.addElement(new CrashJava());
        }
        System.out.println(v);*/
        System.out.println(new CrashJava());
    }
}
