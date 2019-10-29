package com.yu.iotutorial;

import java.io.*;

public class IOTest03 {
    private final String s = File.separator;
    private  String projDir;

    {
        try {
            projDir = new File("").getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        String srcDir = "C:/1.pdf";
        File src = new File(srcDir);
        BufferedInputStream is = new BufferedInputStream(new FileInputStream(src));
        //FileInputStream is = new FileInputStream(src);

        String desDir = "C:\\Users\\pengyu\\Desktop\\1.pdf";
        File des = new File(desDir);
        BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(des));
        //FileOutputStream os = new FileOutputStream(des);
        byte[] bf = new byte[161*1024*1024];
        long start = System.currentTimeMillis();
        for (int len=0;(len=is.read(bf))!=-1;) {
            os.write(bf);
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        os.close();
        is.close();

    }

}
