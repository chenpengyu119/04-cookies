package com.yu.server;

import com.yu.thread.EmpThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author pengyu
 */
public class Server {

    public static void main(String[] args) {

        System.out.println("-----------------服务器开启-------------------------");
        ServerSocket server = null;
        try {
            server = new ServerSocket(9999);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            // 监听得到socket对象
            Socket client = null;
            try {
                client = server.accept();
                Thread thread = new Thread(new EmpThread(client));
                thread.start();

            }catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
