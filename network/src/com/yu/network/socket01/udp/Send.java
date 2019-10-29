package com.yu.network.socket01.udp;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.concurrent.*;

/**
 * @author pengyu
 */
public class Send {

    static ThreadFactory namedFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
    static ExecutorService singleThreadPool = new ThreadPoolExecutor(2, Integer.MAX_VALUE,
            60L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1024), namedFactory,
            new ThreadPoolExecutor.AbortPolicy());


    public static void main(String[] args) {
        // 本程序的端口

        int revport = 5001;
        DatagramSocket send = null;

        try {
            send = new DatagramSocket(revport);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        // 接收
        int revPort = 5002;
        DatagramSocket receive = null;
        try {
            receive = new DatagramSocket(revPort);
        } catch (SocketException e) {
            e.printStackTrace();
        }


        while (true) {

            // 发送线程
            SendThread sendThread = new SendThread(send);
            singleThreadPool.execute(sendThread);

            // 接收线程

            byte[] bytes = new byte[1024];

            DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
            try {
                assert receive != null;
                receive.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }

            ReceiveThread receiveThread = new ReceiveThread(receive,packet);

            singleThreadPool.execute(receiveThread);


        }


    }
}
