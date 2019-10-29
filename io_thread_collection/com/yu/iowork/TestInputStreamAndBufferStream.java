package com.yu.iowork;

import java.io.*;

/**
 * 测试文件流和缓冲流复制文件的效率
 * @author pengyu
 */
public class TestInputStreamAndBufferStream {

    static File file = new File("E:/BaiduNetdiskDownload/Git视频教程（进阶篇）/视频/视频/22、使用gretty进行remote调试.mp4");
    static String pathname = "E:/BaiduNetdiskDownload/Git视频教程（进阶篇）/视频/复制文件夹/copy.mp4";
    static File file2 = new File(pathname);

    public static void main(String[] args) {

        copyByBufferedStream();

    }

    static void copyByBufferedStream(){

        BufferedInputStream is = null;
        BufferedOutputStream os = null;
        try {
            is = new BufferedInputStream(new FileInputStream(file));
            os = new BufferedOutputStream(new FileOutputStream(file2));
            byte[] bf = new byte[1024];
            int len;
            long start = System.currentTimeMillis();
            for (;(len = is.read(bf))!=-1;){
                os.write(bf);
            }
            long end = System.currentTimeMillis();
            System.out.println(end-start);  //300

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
                is.close();
            }catch (IOException e2){
                e2.printStackTrace();
            }
        }

    }

    static void copyByFileInputStream(){

        // 使用文件流
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(file);
            os = new FileOutputStream(file2);
            byte[] bf = new byte[1024];
            int len = 0;
            long start1 = System.currentTimeMillis();
            for (;(len = is.read(bf))!=-1;) {
                os.write(bf);
            }
            long end1 = System.currentTimeMillis();
            System.out.println(end1-start1);  // 900
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
