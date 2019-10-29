package com.yu.iowork;

import java.io.*;

/**
 * 3.	实现字节数组和任何基本类型和引用类型执行的相互转换
 * 提示：使用ByteArrayInutStream和ByteArrayOutputStream。
 * @author pengyu
 * 注意：不能直接将一个简单的byte数组转成其他数据类型（不能直接读取自定义的字节数组），
 * 而是必须先将该元素通过数组流写入字节数组，然后才能进行读取（转换成其他类型）
 */
public class TestSwapWithByteArray<E> {


    /**
     * 其他转字节数组
     */
    byte[] swapToByte(E e){
        // 用输出流
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(bos);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            oos.writeObject(e);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return bos.toByteArray();
    }

    E swapToOther(byte[] buf) {
        buf = new TestSwapWithByteArray().swapToByte(buf);
        ByteArrayInputStream bis = new ByteArrayInputStream(buf);
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(bis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Object o = null;
        try {
            o = ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (E)o;
    }

    public static void main(String[] args) {

        TestSwapWithByteArray test = new TestSwapWithByteArray();
        byte[] bytes = test.swapToByte(new String("hello"));
        // 自定义了一个字节数组，而不是从数组流生成出来的，
        String world = "world";
        bytes = world.getBytes();
        System.out.println(test.swapToOther(bytes).getClass());


        Object obj = (Object)test.swapToOther(bytes);
        System.out.println((new String((byte[])obj)));

    }

}
