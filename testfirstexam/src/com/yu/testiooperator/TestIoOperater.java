package com.yu.testiooperator;

import java.io.*;
import java.util.*;

/**
 * @author pengyu
 */
public class TestIoOperater {

    static TreeMap<Integer,Student> stuMap = new TreeMap<>();

    static String pathname = "stuFile.txt";
    static File stuFile;

    static {
        if (stuFile==null){
            stuFile = new File(pathname);
        }
        if (!stuFile.exists()) {
            try {
                stuFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 读取文件

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(stuFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String stuStr = null;
        // Student{stuNo=3, name='陈六', age=19}
        while (true) {
            try {
                if (((stuStr=reader.readLine())==null)) {
                    break;
                }else {
                    int stuNoIndex = stuStr.indexOf("=")+1;
                    int stuNo = Integer.parseInt(stuStr.substring(stuNoIndex, stuStr.indexOf(",")));

                    int nameIndex1 = stuStr.indexOf("'")+1;
                    int nameIndex2 = stuStr.lastIndexOf("'");
                    String name = stuStr.substring(nameIndex1,nameIndex2);

                    int ageIndex1 = stuStr.lastIndexOf("=")+1;
                    int ageIndex2 = stuStr.lastIndexOf("}");
                    int age = Integer.parseInt(stuStr.substring(ageIndex1, ageIndex2));
                    stuMap.put(stuNo, new Student(stuNo, name, age));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("输入学生信息：格式：编号#姓名#年龄");
            String in = input.next();
            // 字符串分割
            int nameIndex = in.indexOf("#")+1;
            int ageIndex = in.lastIndexOf("#")+1;

            int stuNo = Integer.parseInt(in.substring(0, nameIndex-1));
            String name = in.substring(nameIndex, ageIndex-1);
            int age = Integer.parseInt(in.substring(ageIndex, in.length()));

            System.out.println("编号："+stuNo+"\t姓名："+name+"\t年龄："+age);

            Set<Integer> keySet = stuMap.keySet();

            boolean exisits = keySet.contains(stuNo);
            if (!exisits) {
                stuMap.put(stuNo, new Student(stuNo, name,
                        age));
            }else {
                System.out.println("编号重复，请重新输入");
            }
            if ("exit".equals(input.next())){
                break;
            }
        }

        // 写入文件
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(stuFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Set<Map.Entry<Integer,Student>> entries = stuMap.entrySet();
        for (Map.Entry entry:entries) {
            Student student = (Student)entry.getValue();
            try {
                writer.write(student.toString());
                writer.write("\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        closer(writer,input);
    }
    private static void closer(Closeable ...close){
        for (Closeable c:close) {
            if (c!=null) {
                try {
                    c.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
