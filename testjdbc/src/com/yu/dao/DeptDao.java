package com.yu.dao;

import com.yu.entity.DeptEntity;

import java.util.List;

public interface DeptDao {

    /**
     * 插入
     * @param deptEntity 部门entity
     * @return 插入结果
     */
    public int insert(DeptEntity deptEntity);

    /**
     * 删除
     * @param deptNo 部门编号
     * @return  删除结果
     */
    public int delete(int deptNo);

    /**
     * 修改
     * @param deptEntity  部门entity
     * @return 修改结果
     */
    public int update(DeptEntity deptEntity);

    /**
     * 查询
     * @return 查询结果
     */
    public List query();
}
