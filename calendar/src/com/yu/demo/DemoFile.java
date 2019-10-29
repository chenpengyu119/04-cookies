package com.yu.demo;


import java.io.File;
import java.io.IOException;

/**
 * 测试文件操作
 */
public class DemoFile {
    public static void main(String[] args) {

        selFile(new File("E:/0A文档/开发工具"));

    }

    static void opeFile(){
        // File 文件或文件夹
        File file1 = new File("E:/0A文档/a.txt");
        // 创建文件
        try {
            System.out.println("创建文件:"+file1.createNewFile());
            File dir = new File("E:/0A文档/software/");
            System.out.println("创建文件夹："+dir.mkdir());

            //  没有父目录创建文件夹
            File dir2 = new File("E:/0A文档/window/software/");
            System.out.println("创建2："+ dir2.mkdirs());

            // 判断
            System.out.println("file1是文件吗："+file1.isFile());
            System.out.println("dir是文件吗："+dir.isDirectory());

            System.out.println("绝对路径："+file1.getAbsolutePath());
            System.out.println("文件名："+file1.getName());

            // 删除
            System.out.println("删除dir2:"+dir2.delete());




        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void selFile(File file){

        File[] files = file.listFiles();
        for (File f:files) {
            if (f.isFile()) {
                System.out.println(f);
            } else if(f.isDirectory()) {
                selFile(f);
            }
        }

    }
}
