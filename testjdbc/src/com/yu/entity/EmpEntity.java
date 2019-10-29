package com.yu.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工entity
 * @author pengyu
 */
public class EmpEntity implements Serializable {

    //private static final long serialVersionUID  = 112;
    int empNo;
    String ename;
    String job;
    int mgr;
    Date hiredate;
    double sal;
    double comm;
    int deptNo;

    public EmpEntity() {
    }

    public EmpEntity(int empNo, String ename, String job, int mgr, Date hiredate, double sal, double comm, int deptNo) {
        this.empNo = empNo;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.deptNo = deptNo;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getMgr() {
        return mgr;
    }

    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public double getComm() {
        return comm;
    }

    public void setComm(double comm) {
        this.comm = comm;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("empNo", empNo)
                .append("ename", ename)
                .append("job", job)
                .append("mgr", mgr)
                .append("hiredate", hiredate)
                .append("sal", sal)
                .append("comm", comm)
                .append("deptNo", deptNo)
                .toString();
    }
}
