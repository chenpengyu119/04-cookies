package com.yu.factory;

import java.lang.reflect.InvocationTargetException;

/**
 * 工厂类
 * @author pengyu
 */
public class HumanFactory {


    public static Human createPerson(Class clazz) throws NoSuchMethodException, IllegalAccessException,
                                                                   InvocationTargetException, InstantiationException {

        return (Human) clazz.getConstructor().newInstance();
    }
}
