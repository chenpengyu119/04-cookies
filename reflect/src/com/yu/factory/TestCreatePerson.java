package com.yu.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/**
 * 测试生成线
 * @author pengyu
 */
public class TestCreatePerson {

    public static void main(String[] args) {

        File file = new File("createPerson.properties");
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String humanType = properties.getProperty("HumanType");
        humanType = "com.yu.factory."+humanType;
        Class clazz = null;
        try {
            clazz = Class.forName(humanType);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Human human = null;
        try {
            human = HumanFactory.createPerson(clazz);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        human.laugh();
        human.talk();

    }
}
