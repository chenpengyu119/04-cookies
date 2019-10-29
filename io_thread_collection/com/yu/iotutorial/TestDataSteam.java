package com.yu.iotutorial;

import java.io.*;

/**
 * 数据流
 * 用来操作java的基本数据类型和字符串
 */
public class TestDataSteam {

    String pathname = "C:\\\\Users\\\\pengyu\\\\Desktop\\\\2.txt";
    File file = new File(pathname);

    public static void main(String[] args) throws IOException {
        TestDataSteam tester = new TestDataSteam();
        tester.wirter();
        tester.reader();


    }

    private void reader() throws IOException {


        InputStream in = new FileInputStream(file);
        DataInputStream is = new DataInputStream(in);

       /* byte[] bf = new byte[1024];
        int len = 0;*/
        // 不能这么读
        /*for (;(len=is.read(bf))!=-1;){
            System.out.println(new String(bf,0,len));
        }*/
        // 同类型按添加顺序
        System.out.println(is.readInt());
        System.out.println(is.readInt());


    }


    private void wirter() throws IOException{

        OutputStream out = new FileOutputStream(file);
        DataOutputStream os = new DataOutputStream(out);
        os.writeInt(520);
        os.writeInt(123);
        os.writeBoolean(true);
        os.writeChar('男');
        os.writeDouble(3.14);

        os.close();


    }
}
