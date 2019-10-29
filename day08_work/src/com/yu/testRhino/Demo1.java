package com.yu.testRhino;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * 使用js的Rhino接口实现java和js之间的交互
 */
public class Demo1 {
    public static void main(String[] args) {
        // 引擎管理的对象
        ScriptEngineManager manager = new ScriptEngineManager();
        // 引擎对象
        ScriptEngine engine = manager.getEngineByName("javascript");
        // 定义变量，并存储到引擎上下文中
        engine.put("msg", "i am a good man");
        String str = "var user = {name:'chenpengyu',age:18,school:['清华大学','北京尚学堂']};";
        str+="print(user.name);";
        // 执行脚本
        try {
            engine.eval(str);
            engine.eval("msg='i am in sxt';");
            System.out.println(engine.get("msg"));
            // 定义函数
            engine.eval("function add(a,b){var sum=a+b;return sum;}");
            // 执行函数
            Invocable jsInvoke = (Invocable)engine;
            Object result1 = jsInvoke.invokeFunction("add", new Object[]{13,20});
            System.out.println(result1);
            // 导入其他java包，使用其他java 包中的java类 jdk1.8后导包这么写
            String jsCode = " var list = java.util.Arrays.asList([\"北京\",\"清华\"])";
            engine.eval(jsCode);
            List<String> list1 = (List<String>)engine.get("list");
            for (String s:list1) {
                System.out.println(s);
            }

            // 执行js文件  getClassLoader()会找bin目录，所以a.js要放到out下面的项目名下面，idea的out和bin 一样
            URL url = Demo1.class.getClassLoader().getResource("a.js");
            FileReader fr = new FileReader(url.getPath());
            engine.eval(fr);
            fr.close();




        } catch (ScriptException | NoSuchMethodException | IOException e) {
            e.printStackTrace();

        }

    }
}
