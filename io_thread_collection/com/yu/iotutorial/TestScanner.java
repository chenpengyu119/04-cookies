package com.yu.iotutorial;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Scanner对IO的支持
 * 可以从文件、网络获取数据
 */
public class TestScanner {
    private void getFromFile() throws FileNotFoundException {

        Scanner input = new Scanner(new File("C:\\Users\\pengyu\\Desktop\\1.txt"));

        while (input.hasNext()){
            System.out.print(input.next());
        }
        input.close();

    }

    private void getFromUrl() throws IOException {
        URL url = new URL("http://www.baidu.com");
        InputStream is = url.openStream();
        byte[] bf = new byte[1024];
        int len = 0;
        for (;(len=is.read(bf))!=-1;){
            System.out.print(new String(bf,0,len));
        }
        is.close();

    }

    public static void main(String[] args) throws IOException {
        TestScanner tester = new TestScanner();
        //tester.getFromFile();
        tester.getFromUrl();
    }
}
