package com.yu.iowork;

import java.io.*;

/**
 * 4.	复制文件夹d:/sxtjava下面所有文件和子文件夹内容到d:/sxtjava2。
 * 提示：涉及单个文件复制、目录的创建、递归的使用
 * @author pengyu
 */
public class TestCopy {
    String srcName = "F:\\sxtjava";
    String desName = "F:\\sxtjava2";
    File src = new File(srcName);
    File des = new File(desName);
    final String separator = "\\";

    void copy(File file){

        String dir = null;
        if (file != null) {
            if (file.isDirectory()) {
                // 应该有的路径 d:/sxtjava2/2
                if (!file.getAbsolutePath().equals(srcName)) {
                    if (delStr(file.getAbsolutePath(), srcName) != null) {
                        dir = desName + separator + delStr(file.getAbsolutePath(), srcName);
                    } else {
                        dir = desName + separator;
                    }
                } else {
                    dir = desName;
                }
                File newFile = new File(dir);
                if (!newFile.exists()) {
                    System.out.println("文件夹目录："+file.getAbsolutePath());
                    System.out.println("文件夹新目录："+dir);
                    newFile.mkdirs();
                }
                for (File file1:file.listFiles()){
                    copy(file1);
                }
            } else if( file.isFile()) {
                // 复制文件
                System.out.println("原目录："+file.getName());
                //if ()    src/1.txt
                String rmSrc = delStr(file.getAbsolutePath(), srcName);
                String addNew = desName + separator +rmSrc;
                System.out.println("新目录："+addNew);
                dir = addNew;
                System.out.println("文件现目录："+dir);
                copyFile(file, new File(dir));
            }
        }
    }

    /**
     * 删除字符串中某一段
     * @param str
     * @param delStr
     */
    String delStr(String str,String delStr){
        // use indexOf
        int start = 0;
        int len = delStr.length();
        if (str.contains(delStr)) {
            start = str.indexOf(delStr);
            String pre = "";
            String last = "";
            pre =  str.substring(0,start);
            last = str.substring(start+len, str.length());
            return pre+last;
        }
        return null;
    }


    void copyFile(File src,File des) {

        FileInputStream is = null;
        FileOutputStream os = null;
        try {
            is = new FileInputStream(src);
            os = new FileOutputStream(des);

            byte[] bytes = new byte[1024];
            int len = 0;
            for (;(len = is.read(bytes))!=-1;){
                os.write(bytes);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (os != null) {
                try {
                    os.close();
                    if (is != null) {
                        is.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    public static void main(String[] args) {

        TestCopy test = new TestCopy();
        test.copy(test.src);
        /*File file = new File("F:\\sxtjava2\\1.txt");
        System.out.println(file.getAbsolutePath());*/
    }

}
