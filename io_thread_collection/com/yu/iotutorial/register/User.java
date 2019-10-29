package com.yu.iotutorial.register;

import java.io.Serializable;
import java.util.Objects;

/**
 * 序列化对象
 */
public class User implements Serializable {
    private static  final  long serialVersionUID = 7278517147718974751L;

    // transient 修饰的属性不会序列化
    private  String name;
    private String pwd;

    public User() {

    }

    public User(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return name.equals(user.name) &&
                pwd.equals(user.pwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pwd);
    }
}
