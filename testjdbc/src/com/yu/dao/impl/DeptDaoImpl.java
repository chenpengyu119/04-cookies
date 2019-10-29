package com.yu.dao.impl;

import com.yu.dao.DeptDao;
import com.yu.dbutils.DbUtils;
import com.yu.entity.DeptEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 部门Dao
 * @author pengyu
 */
public class DeptDaoImpl implements DeptDao {
    @Override
    public int insert(DeptEntity deptEntity) {
        String sql = "insert into dept values(?,?,?)";
        return DbUtils.update(sql, deptEntity.getDeptNo(),deptEntity.getdName(),deptEntity.getLoc());
    }

    @Override
    public int delete(int deptNo) {
        String sql = "delete from dept where deptno = ?";
        return DbUtils.update(sql, deptNo);
    }

    @Override
    public int update(DeptEntity deptEntity) {
        String sql = "update dept set deptno = ? , dname = ? , loc = ? where deptno = ?";
        return DbUtils.update(sql, deptEntity.getDeptNo(),deptEntity.getdName(),deptEntity.getLoc(),
                deptEntity.getDeptNo());
    }

    @Override
    public List query() {

        // 获取连接
        Connection conn = DbUtils.getConn();
        // 声明对象
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<DeptEntity> deptEntityList = new ArrayList<>();
        try {
           String sql = "select * from dept";
           ps = conn.prepareStatement(sql);
           // 执行查询
            rs = ps.executeQuery();
            while (rs.next()) {
                DeptEntity deptEntity = new DeptEntity();
                deptEntity.setDeptNo(rs.getInt("deptno"));
                deptEntity.setdName(rs.getString("dname"));
                deptEntity.setLoc(rs.getString("loc"));
                deptEntityList.add(deptEntity);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // 关闭连接
            DbUtils.close(rs, ps, conn);
        }

        return deptEntityList;
    }
}
