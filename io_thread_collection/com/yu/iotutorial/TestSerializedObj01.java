package com.yu.iotutorial;

import java.io.*;

/**
 * 序列化和反序列化
 * 读取顺序和写入顺序一致
 */
public class TestSerializedObj01 {

    String pathname = "C:\\Users\\pengyu\\Desktop\\3.txt";
    File file = new File(pathname);
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        TestSerializedObj01 tester = new TestSerializedObj01();
        tester.writer();
        tester.reader();
    }


    private void reader() throws IOException, ClassNotFoundException {

        InputStream in = new FileInputStream(file);
        ObjectInputStream is = new ObjectInputStream(in);
        Object user = is.readObject();
        Object str = is.readObject();
        if (user instanceof User){
            System.out.println(((User)user).getName());
        }
        if (str instanceof  String){
            System.out.println((String)str);
        }
        is.close();

    }

    private void writer() throws IOException {
        User u1 = new User("张三","002");
        OutputStream out = new FileOutputStream(file);
        ObjectOutputStream os = new ObjectOutputStream(out);

        os.writeObject(u1);
        os.writeObject(new String("1222222"));
        os.close();
    }
}
