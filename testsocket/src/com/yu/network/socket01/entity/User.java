package com.yu.network.socket01.entity;

import java.io.Serializable;

/**
 * @author pengyu
 */
public class User implements Serializable {
    private static final Long serialVersionUID = 123456789L;

    private String uName;
    private String pwd;

    public User(String uName, String pwd) {
        this.uName = uName;
        this.pwd = pwd;
    }


    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
