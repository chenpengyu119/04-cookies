package com.yu.dynamicCompile;

import javax.print.DocFlavor;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;


/**
 * 动态编译
 * 1.通过开启一个新的进程来实现
 * 2.通过API动态编译
 * @author pengyuchen
 */
public class TestDynamicCompile {
    public static void main(String[] args) {

        /**
         * 1.通过Runtimed调用javac，然后启动一个新的进程
         */
        Runtime runtime = Runtime.getRuntime();
        // E:\IdeaProjects\04-cookies
        try {
            Process process = runtime.exec("javac -cp E:/IdeaProjects/04-cookies HelloWorld.java");
        } catch (IOException e) {
            e.printStackTrace();
        }

         // 2.通过JavaCompile实现

        String code = "public class HelloWorld{\n" +
                "\tpublic static void main(String[] args){\n" +
                "\t\tSystem.out.println(\"HelloWorld\");\n" +
                "\t}\n" +
                "}";
        // 通过IO流写入临时文件
        File file = new File("E:/IdeaProjects/04-cookies/HelloWorld.java");
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(file);
            fos.write(code.getBytes());
        }catch (Exception e){
            System.out.println("文件读取失败");
        }finally {
            if (fos!=null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



        // 获得对象
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        // 返回值为是否成功与否 参数1:inputStream; 参数2:OutputStream;  参数3:输入流
        int res = compiler.run(null, null, null, "E:/IdeaProjects/04-cookies/HelloWorld.java");
        System.out.println(res==0?"编译成功":"编译失败");



        // 1.通过Runtime动态运行
        runtime = Runtime.getRuntime();
        // E:\IdeaProjects\04-cookies
        try {
            Process process = runtime.exec("java -cp E:/IdeaProjects/04-cookies HelloWorld");
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String info = "";
            while ((info=reader.readLine())!=null) {
                System.out.println(info);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2.通过反射运行编译好的类
        try {
            String dir = "E:/IdeaProjects/04-cookies/";
            URL[] urls = new URL[]{new URL("file:/"+dir)};
            URLClassLoader loader = new URLClassLoader(urls);
            Class c = loader.loadClass("HelloWorld");
            // 调用main方法
            Method method = c.getMethod("main", String[].class);
            // invoke参数1为对象，main为静态方法，所以直接传null； 第二个参数是传递参数，因为是数组类型，所以要强转Object
            // 如果不强转，可变参数是5.0加入，会编译成main("aa","bb")
            method.invoke(null, (Object)new String[]{"aa","bb"});
        }catch (MalformedURLException | ClassNotFoundException | NoSuchMethodException
                | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

}
