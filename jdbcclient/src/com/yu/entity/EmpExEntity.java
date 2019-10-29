package com.yu.entity;

import java.io.Serializable;

public class EmpExEntity extends EmpEntity implements Serializable {

    private static final long serialVersionUID  = 113;
    private String dName;
    private String loc;

    public EmpExEntity() {
    }

    public EmpExEntity(String dName, String loc) {
        this.dName = dName;
        this.loc = loc;
    }

    public EmpExEntity(int empNo, String eName, String job, String mgr, String hiredate, double sal, double comm, int deptNo, String dName, String loc) {
        super(empNo, eName, job, mgr, hiredate, sal, comm, deptNo);
        this.dName = dName;
        this.loc = loc;
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

    @Override
    public String toString() {
        return "EmpExEntity{" +
                "dName='" + dName + '\'' +
                ", loc='" + loc + '\'' +
                ", empNo=" + empNo +
                ", eName='" + eName + '\'' +
                ", job='" + job + '\'' +
                ", mgr='" + mgr + '\'' +
                ", hiredate='" + hiredate + '\'' +
                ", sal=" + sal +
                ", comm=" + comm +
                ", deptNo=" + deptNo +
                "} " + super.toString();
    }
}
