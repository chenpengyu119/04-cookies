package com.yu.iowork;

import java.io.*;

/**
 * @author pengyu
 */
public class TestIO2 {

    public static void main(String[] args) {

        String pathname = "a.txt";
        File file = new File(pathname);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        OutputStream os = null;
        try {
            os = new FileOutputStream(file);
            String str = "hellohellohellohellohellohellohellohellohellohellohellohello";
            os.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        OutputStream f = null;
        try {
            f = new FileOutputStream(new File("a.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                f.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
