package com.yu.spider;

import java.io.File;
import java.io.IOException;

/**
 * @author pengyu
 */
public class OpenSpider {

    /**
     * 文件路径
     */
    private  static String file_txt = "F:/Program Files (x86)/3000soft/Red Spider/REDAgent.txt";

    private  static String file_exe = "F:/Program Files (x86)/3000soft/Red Spider/REDAgent.exe";

    private  static File txtFile = new File(file_txt);

    private  static File exeFile = new File(file_exe);


    private static void openSpider(){

        // 判断文件类型
        if (!exeFile.exists()){
            System.out.println("需要重命名");
            boolean res = txtFile.renameTo(exeFile);
            System.out.println("是否成功改为exe:"+res);
        }
        // 打开软件
        Runtime rt = Runtime.getRuntime();
        try {
            rt.exec(String.valueOf(file_exe));
        } catch (IOException e) {
            System.err.println("打开软件失败！");
        }
    }

    public static void main(String[] args) {
        openSpider();
    }

}
