package com.yu.iotutorial;

import java.io.*;

/**
 * 测试输入输出
 */
public class IOTest00 {
    private final String s = File.separator;
    private  String projDir;

    {
        try {
            projDir = new File("").getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        IOTest00 tester = new IOTest00();
        tester.reader(tester.writer());
    }

    private String writer(){
        String res = "";
        /**
         * 读取
         */
        File src = null;
        src = new File(projDir+s+"democollection"+s+"read_file.txt");
        InputStream is = null;
        try {
            is = new FileInputStream(src);
            byte[] bf = new byte[1024];
            for (int len=0;(len = is.read(bf))!=-1;){
                System.out.print(res+=new String(bf,0,len));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e2) {
            e2.printStackTrace();
        }finally {
            if (null!=is){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return res;
    }

    private void reader(String book){
        File directory = new File("");
        String pathname = null;
        pathname = projDir+"/democollection/write_file.txt";
        File src = new File(pathname);
           OutputStream os = null;
        try {
            os = new FileOutputStream(src);
            byte[] bf = book.getBytes();
            os.write(bf);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null!=os){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

