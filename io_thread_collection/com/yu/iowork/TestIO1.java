package com.yu.iowork;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author pengyu
 */
public class TestIO1 {

    public static void main(String[] args) {

        String str = "Hello World";
        FileWriter fw = null;
        try {
            fw = new FileWriter("c:\\hello.txt"); // 1
            fw.write(str);                     // 2
        } catch (IOException e) {
            e.printStackTrace();                // 3
        } finally {
            try {
                fw.close();                        // 4
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
