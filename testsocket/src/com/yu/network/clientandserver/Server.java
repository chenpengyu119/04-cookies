package com.yu.network.clientandserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author pengyu
 */
public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("--------------服务器端开启---------------");
        int port = 9999;
        ServerSocket server = new ServerSocket(port);

        Socket client = server.accept();
        InputStream in = client.getInputStream();
        DataInputStream dis = new DataInputStream(in);
        OutputStream out = client.getOutputStream();
        DataOutputStream dos = new DataOutputStream(out);

        System.out.println("小明："+dis.readUTF());
       // System.out.println("接收完毕……");
        dos.writeUTF("不在，洗澡去了");

        dos.close();
        dis.close();
        in.close();
        client.close();
        server.close();



    }
}
