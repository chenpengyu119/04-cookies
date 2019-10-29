package com.yu.entity;

import java.io.Serializable;

/**
 * 表dept
 * @author pengyu
 */
public class DeptEntity implements Serializable {

    private static final long serialVersionUID  = 111;
    private int deptNo;
    private String dName;
    private String loc;

    public DeptEntity() {
    }

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

}
