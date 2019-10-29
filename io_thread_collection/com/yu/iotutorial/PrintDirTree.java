package com.yu.iotutorial;

import java.io.File;

/**
 * @author pengyu
 */
public class PrintDirTree {
    public static void main(String[] args) {
        String pathname = "E:/0A文档";
        File file = new File(pathname);
        PrintDirTree print = new PrintDirTree();
        print.showFile(file,0);
    }

    /**
     * 递归打印目录
     * @param file
     */

    File[] files;
    private void showFile(File file,int count){
        for (int i=0;i<count;i++){
            System.out.print("\t");
        }
        System.out.println(file.getName());
        if (file == null|| !file.exists()){
            return;
        }
        if(file.isFile()){
            System.out.print(file.getName()+"\n");
        }else if (file.isDirectory()){
            if ((files = file.listFiles()) != null) {
                for (File file1 : files) {
                    showFile(file1,count++);

                }
            }
        }
    }
}
