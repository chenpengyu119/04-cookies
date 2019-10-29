package com.yu.closespider;

import java.io.File;
import java.io.IOException;

/**
 * 先重命名文件
 * 然后结束进程
 * @author pengyu
 */
public class CloserSpider {
    /**
     * 文件路径
     */
    private  static String file_txt = "F:/Program Files (x86)/3000soft/Red Spider/REDAgent.txt";

    private  static String file_exe = "F:/Program Files (x86)/3000soft/Red Spider/REDAgent.exe";

    private  static File txtFile = new File(file_txt);

    private  static File exeFile = new File(file_exe);

    private static void rename(){

        if (!txtFile.exists()){
            if (exeFile.exists()){
                exeFile.renameTo(txtFile);
                System.out.println("重命名成功");
            }
        }
    }

    public static void main(String[] args) { //closer();
        killProcess();
        rename();
    }

    public static void killProcess(){
        Runtime rt = Runtime.getRuntime();
        Process p = null;
        try {
            rt.exec("cmd.exe /C start wmic process where name='REDAgent.exe' call terminate");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
