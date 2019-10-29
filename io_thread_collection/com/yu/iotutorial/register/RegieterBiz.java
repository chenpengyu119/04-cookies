package com.yu.iotutorial.register;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class RegieterBiz {

    private Scanner input = new Scanner(System.in);

    private ArrayList<User> users = new ArrayList<>();

    private final String pathname = "userList.txt";
    private final File file = new File(pathname);

    // 初始化，创建管理员账户
    {
        // 判断文件是否存在，初始化契机
        if (file==null || !file.exists()){
            // 添加管理员
            users.add(new User("admin", "toor"));
            // 写入磁盘
            writer();
        }else {// 文件存在则读取存储记录
            reader();
        }

    }

    public void mainMenu(){
        int choice = 0;
        while (true){
            System.out.println("---------------1.注册   2.登陆  3.退出--------------------");
            choice = input.nextInt();
            switch (choice){
                case 1:// 注册
                    regieter();
                    continue;
                case 2:// 登陆
                    login();
                    continue;
                case 3:
                    System.out.println("程序结束");
                    break;
                default:
                    System.out.println("输入的选项有误");
                    continue;
            }
        }
    }

    /**
     * 从文件读取到list
     * @return
     */
    private void reader(){
        ObjectInputStream is = null;
        try {// 对象输入流
            is = new ObjectInputStream(new FileInputStream(file));
            Object obj = null;
            try {
                obj = is.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            // 类型判断
            if(obj instanceof ArrayList) {
                users = (ArrayList<User>)obj;
            }
        }catch (IOException e){
            System.err.println("文件读取失败");
            e.printStackTrace();
        }finally {
            try {
                if(is!=null) {
                    is.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 将list写入文件
     */
    private void writer(){
        ObjectOutputStream os = null;
        try {// 对象输出流
            os = new ObjectOutputStream(new FileOutputStream(file));
            os.writeObject(users);
        } catch (IOException e) {
            System.err.println("写入文件失败");
        }finally {
            try {// 关闭对象流
                if (os!=null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 登陆
     */
    private void login() {
        System.out.println("--------------->用户登陆");
        System.out.println("用户名：");
        String name = input.next();
        System.out.println("密码：");
        String pwd = input.next();
        if (name != null){
            for (User user : users){
                if(name.equals(user.getName()) && pwd.equals(user.getPwd())){
                    System.out.println("登陆成功");
                    return;
                }
            }
        }
        System.out.println("用户名或密码不正确");
    }

    /**
     * 注册
     */
    private void regieter() {
        System.out.println("------------->注册账号");
        System.out.println("请输入用户名：");
        String name = input.next();
        // 判断是否存在
        boolean isRepeat = checkUser(name);
        if (isRepeat){
            System.out.println("用户名已存在");
            return;
        }
        System.out.println("请输入密码：");
        String pwd = input.next();
        users.add(new User(name, pwd));
        System.out.println("注册成功");
        writer();
    }

    /**
     * 检查重复
     * @return 重复为true
     */
    private boolean checkUser(String name){

        for (User user : users){
            if (user.getName() != null && user.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
}
