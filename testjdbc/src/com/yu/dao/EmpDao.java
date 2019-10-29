package com.yu.dao;

import com.yu.entity.EmpEntity;

import java.util.List;

/**
 * @author pengyu
 */
public interface EmpDao {

    /**
     * 增加
     * @param empEntity
     * @return
     */
  public int insert(EmpEntity empEntity);

    /**
     * 删除
     * @param empNo 员工号
     * @return
     */
  public int delete(int empNo);

    /**
     * 更新
     * @param empEntity
     * @return
     */
  public int update(EmpEntity empEntity);

    /**
     * 查询所有员工信息
     * @return 员工实体
     */
    public List query();

  /**
   * 查询所有员工信息,包括部门详细信息
   * @return 员工实体
   */
  public List query2();

  /**
   * 条件查询
   * @return 员工实体
   */
  public List querybyName(String ename);

}
