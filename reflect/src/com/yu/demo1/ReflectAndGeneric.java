package com.yu.demo1;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 反射可以跳过编译，在运行期对泛型进行赋值
 * @author pengyu
 */
public class ReflectAndGeneric {

    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("hello");

        // arrayList.add(1);
        Class clazz = arrayList.getClass();

        // 获取方法
        Method add = null;
        try {
            add = clazz.getDeclaredMethod("add",Object.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        // 调用
        try {
            add.invoke(arrayList, 123);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(arrayList.size());
        // 无法单独获取值
        // System.out.println( arrayList.get(1));
        System.out.println(arrayList);



    }
}
