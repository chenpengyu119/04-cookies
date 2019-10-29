package com.yu.test;

import com.yu.dao.DeptDao;
import com.yu.dao.impl.DeptDaoImpl;
import com.yu.entity.DeptEntity;

import java.util.List;

/**
 * 部门管理测试
 * @author pengyu
 */
public class TestDept {

    public static void main(String[] args) {

        DeptDao deptDao = new DeptDaoImpl();
        DeptEntity entity = new DeptEntity();
        entity.setDeptNo(4);
        entity.setdName("开发");
        entity.setLoc("北京");
        // 增加
        /*int res = deptDao.insert(entity);
        */

        // 改
        //int res = deptDao.update(entity);

        // 删除
        //int res = deptDao.delete(4);

        //System.out.println(res > 0?"成功":"失败");

        // 查询
        List<DeptEntity> entityList = deptDao.query();

        for (DeptEntity entity1:entityList) {
            System.out.println(entity1.getDeptNo()+"\t"+entity1.getdName()+"\t"+entity1.getLoc());
        }
    }
}
