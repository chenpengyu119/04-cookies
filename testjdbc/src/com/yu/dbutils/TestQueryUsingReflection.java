package com.yu.dbutils;

import com.yu.entity.EmpEntity;

import java.util.List;

/**
 * 测试经过修改添加了反射的查询
 * @author pengyu
 */
public class TestQueryUsingReflection {

    public static void main(String[] args) {

        String sql = "select * from emp";
        Class clazz = null;
        try {
            clazz = Class.forName("com.yu.entity.EmpEntity");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        List<EmpEntity> list = DbUtils.queryGeneral(sql, clazz);

        for (EmpEntity entity:list) {
            System.out.println(entity);
        }




    }


}
