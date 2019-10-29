package com.yu.network.socket01.udp2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SendThread implements Runnable {

    DatagramSocket send ;

    public SendThread(DatagramSocket send) {
        this.send = send;
    }

    @Override
    public void run() {

        Scanner input = new Scanner(System.in);
        System.out.print("消息：");
        String message = input.next();
        byte[] bytes = message.getBytes();
        // 要发送到的端口
        int sendPort = 5002;
        DatagramPacket packet = null;
        try {
            packet = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.141.33"), sendPort);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        try {
            send.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
