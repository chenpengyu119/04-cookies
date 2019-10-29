package com.yu.network.socket01.udp2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveThread implements Runnable {

    private DatagramSocket receive;

    private DatagramPacket packet;

    public ReceiveThread(DatagramSocket receive,DatagramPacket packet) {
        this.receive = receive;
        this.packet = packet;
    }

    @Override
    public void run() {


        String str = new String(packet.getData(), 0, packet.getLength());
        System.out.println("新消息：" + str);

    }
}
