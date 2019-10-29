package com.yu.iotutorial;

import java.io.*;

/**
 * 标准步骤
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放
 * 文件字节流 蚂蚁搬家一个一个读取
 */
public class IOTest01 {

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
            for (int temp=0;(temp = is.read())!=-1;){
                System.out.print((char)temp);
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
