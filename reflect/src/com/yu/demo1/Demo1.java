package com.yu.demo1;

import com.yu.entity.Student;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * @author pengyu
 */
public class Demo1 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("类名：");
        String className = "com.yu.entity."+input.next();
        Class clazz = null;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Student stu = null;
        try {
            stu = (Student) clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }catch (NoSuchMethodException e){
            e.printStackTrace();
        }catch (InvocationTargetException e){
            e.printStackTrace();
        }
        // 属性
        Field[] fields = clazz.getDeclaredFields();
        String fieldName = fields[0].getName();
        String upperName = Character.toUpperCase(fieldName.charAt(0))+fieldName.substring(1);
        // set
        String setMethod = "set"+upperName;
        // get
        String getMethod = "get"+upperName;
        Method set = null;
        Method get = null;
        try {
             set = clazz.getMethod(setMethod,int.class);
             get = clazz.getMethod(getMethod);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            // 传递对象，以及实参
            set.invoke(stu, 50);
            int stuNo = (Integer)get.invoke(stu);
            System.out.println(stuNo);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        // 获取方法
        System.out.println(set.getGenericParameterTypes()[0]);



    }
}
