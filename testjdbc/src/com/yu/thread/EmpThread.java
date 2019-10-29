package com.yu.thread;

import com.yu.dao.EmpDao;
import com.yu.dao.impl.EmpDaoImpl;
import com.yu.entity.EmpEntity;
import com.yu.entity.EmpExEntity;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpThread implements Runnable {

    private Socket socket ;



    public EmpThread() {
    }

    public EmpThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        // 获取数据
        InputStream is = null;
        ObjectInputStream ois = null;
        HashMap<String,Object> hashMap = null;

        // 返回数据
        OutputStream os = null;
        ObjectOutputStream oos = null;
        try {
            // 接收数据
            is = socket.getInputStream();
            ois = new ObjectInputStream(is);
            hashMap = (HashMap<String, Object>) ois.readObject();
            socket.shutdownInput();
            String operator = null;
            Object obj = null;
            for (Map.Entry<String,Object> entry:hashMap.entrySet()) {
                if ("flag".equals(entry.getKey())) {
                    operator = (String) entry.getValue();
                }
                if ("obj".equals(entry.getKey())) {
                    obj = entry.getValue();
                }
            }
            System.out.println("接收到一条"+operator+"请求");

            EmpDao empDao = new EmpDaoImpl();
            switch (operator) {
                case "select":
                    List<EmpExEntity> empExEntityList = empDao.query2();
                    os = socket.getOutputStream();
                    oos = new ObjectOutputStream(os);
                    oos.writeObject(empExEntityList);
                    socket.shutdownOutput();
                    break;
                case "insert":
                    empDao = new EmpDaoImpl();
                    int res = 0;
                    if (obj instanceof EmpEntity) {
                        res = empDao.insert((EmpEntity) obj);
                    }
                    // 响应
                    os = socket.getOutputStream();
                    oos = new ObjectOutputStream(os);
                    oos.writeInt(res);
                    oos.flush();
                    socket.shutdownOutput();
                    break;
                 default:
                        break;
            }

        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e2){
            e2.printStackTrace();
        }finally {
            close(oos,os,ois,is,socket);
        }
    }

    private static void close(Closeable...closeables) {
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
