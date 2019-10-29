package com.yu.bird;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BirdFactory {

    public static Bird createBird(String type)  {

        try {
            Class c = Class.forName(type);
            Constructor constructor = c.getConstructor();

            return (Bird)constructor.newInstance();
        } catch (ClassNotFoundException e) {
            System.out.println("没找到类");
        } catch (NoSuchMethodException e) {
            System.out.println("没找到方法");
        } catch (IllegalAccessException e) {
            System.out.println("不合法访问");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}
