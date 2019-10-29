package com.yu.biz;

import com.yu.entity.EmpEntity;
import com.yu.entity.EmpExEntity;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MainMenu {

    static Scanner input = new Scanner(System.in);
    static String host = "localhost";
    static int port = 9999;

    static Socket client = null;
    static OutputStream os = null;
    static ObjectOutputStream oos = null;

    static InputStream is = null;
    static ObjectInputStream ois = null;

    public static void mainMenu(){
        while (true) {
            System.out.println("------1.添加员工信息--2.员工离职--3.修改员工信息--4.查询所有员工信息--5.按照姓名查询员工信息---0.退出系统------");

            int choice = input.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("谢谢使用");
                    break;
                case 1:
                    insert();
                    continue;
                case 2:
                    continue;
                case 3:
                    continue;
                case 4:
                    selectAll();
                    continue;
                case 5:
                    continue;
                default:
                    System.out.println("选项不正确，请重新输入");
                    break;
            }
        }
    }

    private static void insert(){

        // 构造数据
        String operator = "insert";
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("flag", operator);
        hashMap.put("obj", getEmp());

        try {
            client = new Socket(host, port);
            os = client.getOutputStream();
            oos = new ObjectOutputStream(os);
            oos.writeObject(hashMap);
            // 截断输出
            client.shutdownOutput();

            // 接收数据
            is = client.getInputStream();
            ois = new ObjectInputStream(is);
            int res = ois.readInt();
            client.shutdownInput();
            System.out.println(res > 0?"插入成功":"插入失败");

        }catch (IOException e1){
            e1.printStackTrace();
        } finally {
            // 关闭流
            close(ois,is,oos,os,client);
        }

    }
    private static EmpEntity getEmp(){
        EmpEntity empEntity = new EmpEntity();
        System.out.println("员工号：");
        empEntity.setEmpNo(input.nextInt());
        System.out.println("员工姓名：");
        empEntity.seteName(input.next());
        System.out.println("职位：");
        empEntity.setJob(input.next());
        System.out.println("直属领导：");
        empEntity.setMgr(input.next());
        System.out.println("入职时间：格式YYYY-mm-DD");
        empEntity.setHiredate(input.next());
        System.out.println("薪水：");
        empEntity.setSal(input.nextDouble());
        System.out.println("津贴：");
        empEntity.setComm(input.nextDouble());
        System.out.println("部门编号：");
        empEntity.setDeptNo(input.nextInt());
        System.out.println(empEntity.toString());
        return empEntity;
    }

    private static void selectAll(){

        // 传输对象
        String operator = "select";
        HashMap<String,Object> hashMap = new HashMap<>();


        try {
            client= new Socket(host,port);
            os = client.getOutputStream();
            oos = new ObjectOutputStream(os);
            // 构造数据
            hashMap.put("flag", "select");
            // 写入传输数据
            oos.writeObject(hashMap);
            // 截断输出流
            client.shutdownOutput();

            // 接收数据
            is = client.getInputStream();
            ois = new ObjectInputStream(is);

            Object o = ois.readObject();
            client.shutdownInput();
            if (o instanceof List) {
                List<EmpExEntity> empExEntityList = (List<EmpExEntity>)o;
                for (EmpExEntity entity: empExEntityList ) {
                    System.out.println(entity.toString());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        }finally {
            close(ois,is,oos,os,client);
        }
    }

    private static void close(Closeable ...closeables) {
        for (Closeable c : closeables) {
            if (c != null) {
                try {
                    c.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



}
