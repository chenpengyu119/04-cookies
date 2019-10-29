package com.yu.tcp1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author pengyu
 * 服务器端:PrintWriter out =new PrintWriter(socket.getOutputStream(),true);
 */
public class TestServer {

    public static void main(String[] args) {
        int port = 9999;
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Socket client = null;
        try {
            client = server.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 读取数据
        InputStream is = null;
        try {
            is = client.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String message = "";
        try {
           // if ((message = reader.readLine())!=null) {
                System.out.println(reader.readLine());
           // }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 发送回应
        PrintWriter out = null;
        try {
            out=new PrintWriter(client.getOutputStream(),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.println("收到了");

        closer(out,reader,is,client,server);
    }

    public static void closer(Closeable ...closeables) {
        for (Closeable closeable : closeables) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
