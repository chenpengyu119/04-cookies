package com.yu.network.clientandserver;

import java.io.*;
import java.net.Socket;

/**
 * @author pengyu
 */
public class Client {
    public static void main(String[] args) throws IOException {
        String dstName = "192.168.141.31";
        int dstPort = 9999;
        Socket client = new Socket(dstName, dstPort);
        OutputStream out = client.getOutputStream();
        DataOutputStream dos = new DataOutputStream(out);
        InputStream in = client.getInputStream();
        DataInputStream dis = new DataInputStream(in);
        try {
                dos.writeUTF("在吗");
               // System.out.println("发送完毕……");
            System.out.println("小红："+dis.readUTF());

        }finally {
            dis.close();
            dos.close();
            client.close();
        }





    }

}
