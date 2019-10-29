package com.yu.dao.impl;

import com.yu.dao.EmpDao;
import com.yu.dbutils.DbUtils;
import com.yu.entity.EmpEntity;
import com.yu.entity.EmpExEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 员工
 * @author pengyu
 */
public class EmpDaoImpl implements EmpDao {

    @Override
    public int insert(EmpEntity empEntity) {
        String sql ="insert into emp values(?,?,?,?,to_date(?,'YYYY-MM-DD'),?,?,?)";
        return DbUtils.update(sql, empEntity.getEmpNo(),empEntity.getEname(),empEntity.getJob()
               ,empEntity.getMgr(),empEntity.getHiredate(),empEntity.getSal(),empEntity.getComm(),empEntity.getDeptNo());
    }

    @Override
    public int delete(int empNo) {
        String sql = "delete from emp where empNo = ?";
        return DbUtils.update(sql, empNo);
    }

    @Override
    public int update(EmpEntity empEntity) {
        String sql = "update into emp set empno = ?, ename = ?, job = ?, mgr = ?, hiredate = ?, sal = ?, comm = ?, deptno = ?";
        return DbUtils.update(sql, empEntity.getEmpNo(),empEntity.getEname(),empEntity.getJob(),
                empEntity.getMgr(),empEntity.getHiredate(),empEntity.getSal(),empEntity.getComm(),empEntity.getDeptNo());
    }

    @Override
    public List query() {

        // 获取连接
        Connection conn = DbUtils.getConn();
        // 数据库对象
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<EmpEntity> empEntityList = new ArrayList<>();
        try {
            String sql = "select * from emp";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                EmpEntity empEntity = new EmpEntity();
                empEntity.setEmpNo(rs.getInt("EMPNO"));
                empEntity.setEname(rs.getString("ENAME"));
                empEntity.setJob(rs.getString("JOB"));
                empEntity.setMgr(rs.getInt("MGR"));
                empEntity.setHiredate(rs.getDate("HIREDATE"));
                empEntity.setSal(rs.getDouble("SAL"));
                empEntity.setComm(rs.getDouble("COMM"));
                empEntity.setDeptNo(rs.getInt("DEPTNO"));
                empEntityList.add(empEntity);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            // 关闭连接
            DbUtils.close(rs, ps, conn);
        }

        return empEntityList;
    }

    @Override
    public List query2() {
        // 获取连接
        Connection conn = DbUtils.getConn();
        // 数据库对象
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<EmpExEntity> empExEntityList = new ArrayList<>();
        try {
            String sql = "select e.* ,d.dname,d.loc from emp e,dept d where e.deptno = d.deptno";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                EmpExEntity empExEntity = new EmpExEntity();
                empExEntity.setEmpNo(rs.getInt("EMPNO"));
                empExEntity.setEname(rs.getString("ENAME"));
                empExEntity.setJob(rs.getString("JOB"));
                empExEntity.setMgr(rs.getInt("MGR"));
                empExEntity.setHiredate(rs.getDate("HIREDATE"));
                empExEntity.setSal(rs.getDouble("SAL"));
                empExEntity.setComm(rs.getDouble("COMM"));
                empExEntity.setDeptNo(rs.getInt("DEPTNO"));
                empExEntity.setdName(rs.getString("dname"));
                empExEntity.setLoc(rs.getString("loc"));
                empExEntityList.add(empExEntity);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            // 关闭连接
            DbUtils.close(rs, ps, conn);
        }

        return empExEntityList;
    }

    @Override
    public List querybyName(String ename) {
        // 获取连接
        Connection conn = DbUtils.getConn();
        // 数据库对象
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<EmpEntity> empEntityList = new ArrayList<>();
        try {
            String sql = "select * from emp where ename like ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, ename);
            rs = ps.executeQuery();
            while (rs.next()) {
                EmpEntity empEntity = new EmpEntity();
                empEntity.setEmpNo(rs.getInt("EMPNO"));
                empEntity.setEname(rs.getString("ENAME"));
                empEntity.setJob(rs.getString("JOB"));
                empEntity.setMgr(rs.getInt("MGR"));
                empEntity.setHiredate(rs.getDate("HIREDATE"));
                empEntity.setSal(rs.getDouble("SAL"));
                empEntity.setComm(rs.getDouble("COMM"));
                empEntity.setDeptNo(rs.getInt("DEPTNO"));
                empEntityList.add(empEntity);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            // 关闭连接
            DbUtils.close(rs, ps, conn);
        }

        return empEntityList;
    }
}
