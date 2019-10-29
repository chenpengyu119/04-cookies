package com.yu.demothread;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;

/**
 * 2.	写一个方法对任意数据类型数组进行排序。
 * 具体要求如下:
 * 1)	方法声明为public  void sortArr(Object arr[]){  }
 * 2)	方法中首先输出排序前数组内容，然后进行排序，最后输出排序后数组内容。
 * 3)	可以是冒泡排序或其他算法实现，不直接调用Java提供的方法实现排序。
 *      关键点：如何实现不同数据类型数组元素的大小比较
 * @author pengyu
 */
public class TestCavePass {

    public void sortArr(Object arr[]) {

        InputStream in = null;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("排序前"+Arrays.toString(arr));

        for (int i=0;i<arr.length;i++) {
            arr[i] = arr[i].hashCode();
        }

        // 冒泡
        for (int j=0;j<arr.length-1;j++) {
            for (int k=0;k<arr.length-(1+j);k++) {

            }
        }


    }

    public static void main(String[] args) {



    }

}
