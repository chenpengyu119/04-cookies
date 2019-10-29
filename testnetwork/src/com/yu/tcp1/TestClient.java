package com.yu.tcp1;

import java.io.*;
import java.net.Socket;

/**
 * 客户端:BufferedReader line=new BufferedReader(new InputStreamReader(System.in));
 * 使用字节缓冲流接收键盘数据，写到输出流
 *
 * @author pengyu
 */
public class TestClient {

    public static void main(String[] args) {

        Socket client = null;
        try {
            client = new Socket("localhost", 9999);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("输入：");
        InputStream input = System.in;
        BufferedReader line = new BufferedReader(new InputStreamReader(input));

        OutputStream os = null;
        try {
            os = client.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String str = null;
        try {
            str = line.readLine();
            if (str != null) {
                os.write(str.getBytes());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        // 如果去除这些，无法关闭输出流，服务器端不知道客户端是否输出完毕
        try {
            client.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 接收回复
        InputStream is = null;
        try {
            is = client.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] bytes = new byte[1024];
        int len = 0;

        try {
            if (!((len = is.read(bytes)) != -1)) {
                System.out.println(new String(bytes, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        closer(is,os,line,input,client);
    }

    public static void closer(Closeable... closeables) {
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
