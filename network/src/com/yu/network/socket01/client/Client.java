package com.yu.network.socket01.client;

import com.yu.network.socket01.entity.User;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author pengyu
 */
public class Client {
    public static void main(String[] args) {
        Socket client = null;
        try {
            client = new Socket("192.168.141.31", 9999);
        } catch (IOException e) {
            e.printStackTrace();
        }
        OutputStream out = null;
        ObjectOutputStream oos = null;
        try {
            if (client != null) {
                out = client.getOutputStream();
                oos = new ObjectOutputStream(out);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (oos != null) {
                oos.writeObject(login());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        InputStream in = null;
        try {
            if (client != null) {
                in = client.getInputStream();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        DataInputStream dis = null;
        if (in != null) {
            dis = new DataInputStream(in);
        }
        try {
            if (dis != null) {
                System.out.println(dis.readUTF());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        closeAll(dis,in,oos,out,client);

    }

    private static void closeAll (Closeable...closes) {
        for (Closeable c: closes) {
            if (c != null) {
                try {
                    c.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static User login() {
        System.out.println("用户名：");
        Scanner input = new Scanner(System.in);
        String uName = input.next();
        System.out.println("密码：");
        String pwd = input.next();
        return new User(uName, pwd);
    }
}
