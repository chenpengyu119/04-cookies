package com.yu.network.socket01.thread;

import com.yu.network.socket01.dao.UserDaoImpl;
import com.yu.network.socket01.entity.User;
import com.yu.network.socket01.server.Server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author pengyu
 */
public class ServerThread implements Runnable{
    Socket client ;

    public ServerThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(client.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean res = false;
        try {
            try {
                res = new UserDaoImpl().query((User) ois.readObject());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String result = res ? Thread.currentThread().getName()+client.getInetAddress()+"--登陆成功"
                :Thread.currentThread().getName()+client.getInetAddress()+ "用户名或密码不正确";
        System.out.println(result);
        OutputStream out = null;
        try {
            out = client.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DataOutputStream dos = new DataOutputStream(out);

        try {
            dos.writeUTF(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Server.closeAll(dos,out,client);
    }
}
