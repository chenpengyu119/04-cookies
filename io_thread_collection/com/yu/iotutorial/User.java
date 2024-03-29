package com.yu.iotutorial;

import java.io.Serializable;

/**
 * 序列化对象
 */
public class User implements Serializable {
    // transient 修饰的属性不会序列化
    private  String name;
    private String id;

    public User() {

    }

    public User(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
