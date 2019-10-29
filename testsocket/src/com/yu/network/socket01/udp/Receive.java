package com.yu.network.socket01.udp;


import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @author pengyu
 */
public class Receive {
    public static void main(String[] args) {
        int revPort = 5002;
        DatagramSocket receive = null;
        try {
            receive = new DatagramSocket(revPort);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        while (true) {
            byte[] bytes = new byte[1024];

            DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
            try {
                assert receive != null;
                receive.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String str = new java.lang.String(packet.getData(), 0, packet.getLength());
            System.out.println("新消息：" + str);

            Scanner input = new Scanner(System.in);
            System.out.print("消息：");
            String message = input.next();
            byte[] messageBytes = message.getBytes();
            // 发送
            DatagramPacket packet1 = null;
            try {
                packet1 = new DatagramPacket(messageBytes, 0, messageBytes.length,
                        packet.getAddress(), packet.getPort());
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                receive.send(packet1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if ("bye".equals(message)) {
                break;
            }
        }

        receive.close();

    }
}
