package com.yu.network.socket01.server;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.yu.network.socket01.thread.ServerThread;

import java.io.Closeable;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * @author pengyu
 */
public class Server {

    static ThreadFactory namedFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
    static ExecutorService singleThreadPool = new ThreadPoolExecutor(2, Integer.MAX_VALUE,
            60L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>(1024),namedFactory,
            new ThreadPoolExecutor.AbortPolicy());
    public static void main(String[] args) throws IOException {
        System.out.println("---------------服务器启动--------------------");
        int port = 9999;

        ServerSocket server = null;
        try {
           server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true){
            assert server != null;
            Socket client = server.accept();
            ServerThread thread = new ServerThread(client);
            singleThreadPool.execute(thread);


        }

    }

    public static void closeAll (Closeable...closes) {
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

}
