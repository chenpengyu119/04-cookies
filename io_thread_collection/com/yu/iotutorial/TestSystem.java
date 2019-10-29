package com.yu.iotutorial;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * System.in : 常量 类型为InputStream  数据源keyboard
 */
public class TestSystem {
    public static void main(String[] args) throws IOException {
        /*System.out.println("输入：");
        InputStream is = System.in;
        int bf = 0;
        // 死循环
        while (( bf= is.read())!=-1){
            System.out.print(bf);
        }
        is.close();*/

        // system.out
        OutputStream os = System.out;
        PrintStream ps = System.out;

        os.write("hello".getBytes());
        ps.println("hello");

        os.close();
        ps.close();


    }
}
