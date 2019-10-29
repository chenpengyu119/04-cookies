package com.yu.iotutorial;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 一段一段地读，放到字节数组
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放
 */
public class IOTest02 {

    public static void main(String[] args) throws IOException {

        File directory = new File("");//设定为当前文件夹
        // 创建源
        String pathname = ""+directory.getCanonicalPath()+"/democollection/read_file.txt";
        File src =  new File(pathname);

        System.out.println(directory.getCanonicalPath());
        InputStream is = null;
        try {
            is = new FileInputStream(src);
            // 操作
            byte[] car = new byte[1024];
            int len=0;
            for (;(len = is.read(car))!=-1;){
                System.out.print(new String(car,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {// 关闭流
            try {
                if(null!=is) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
