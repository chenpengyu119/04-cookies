package com.yu.network;

import java.io.IOException;
import java.net.*;

/**
 * @author pengyu
 */
public class Demo1 {

    public static void main(String[] args) {

        InetAddress[] inetAddresses = null;
        try {
            inetAddresses = InetAddress.getAllByName("DESKTOP-D2L7BHH");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.print("ip+mac:");
        for (InetAddress in:inetAddresses) {
            System.out.print(in.getHostAddress()+"\t");
        }
        System.out.println("");

        String spec  = "https://www.google.com/search";
        URL url = null;
        try {
            url = new URL(spec);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if(url != null ) {
            System.out.println("path:\t" + url.getPath());
        }
        URLConnection conn = null;
        try {
            conn = url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        conn.setRequestProperty("q", "tcp");
        Object content = null;
        try {
            content = conn.getContent();
            conn.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println((String)content);
    }


}
