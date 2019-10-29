package com.yu.test;

import com.yu.dao.EmpDao;
import com.yu.dao.impl.EmpDaoImpl;
import com.yu.entity.EmpEntity;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author pengyu
 */
public class TestEmp {

    public static void main(String[] args) {

        EmpDao empDao = new EmpDaoImpl();
        EmpEntity empEntity = new EmpEntity();
        empEntity.setEmpNo(1290);
        empEntity.setEname("ALIBABA");
        empEntity.setJob("MANAGER");
        empEntity.setMgr(111);
        String pattern = "yyyy-MM-dd";
        Format format = new SimpleDateFormat(pattern);
        String date = format.format(new Date());
        try {
            empEntity.setHiredate(((SimpleDateFormat) format).parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        empEntity.setSal(20000.0);
        empEntity.setComm(10000.0);
        empEntity.setDeptNo(40);
        // 测试插入
        int res = empDao.insert(empEntity);
        System.out.println(res > 0?"成功":"失败");

        /*List<EmpEntity> empEntityList = empDao.query();
        for(EmpEntity empEntity1:empEntityList) {
            System.out.println(empEntity1.getEmpNo()+"\t"+empEntity1.geteName());
        }*/

  /*      List<EmpEntity> empEntityList = empDao.querybyName("%A%");
        for (EmpEntity empEntity:empEntityList) {
            System.out.println(empEntity.toString());
        }*/

    }
}
