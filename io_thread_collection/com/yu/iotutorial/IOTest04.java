package com.yu.iotutorial;

import java.io.*;

/**
 * Io复习
 * 数据流和对象流
 */
public class IOTest04 {

    private static String  pathname  = "binary.txt";
    private static File src = new File(pathname);
    public static void main(String[] args) throws IOException {
        // 数据流
        // 属于处理流，针对二进制文件， 专门操作java基本数据类型和字符串

        // 输出
        DataOutputStream os = new DataOutputStream(new FileOutputStream(src));
        os.writeInt(111);
        os.writeUTF("哈喽");
        os.writeDouble(3.14);
        os.close();
        // 输入
        //DataInputStream



    }
}
