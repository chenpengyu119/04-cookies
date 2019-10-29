package com.yu.test;

import com.yu.threadtutorial.ExampleThread;

/**
 * 测试继承thread的类
 * @author pengyu
 */
public class ExampleThreadTest {
    public static void main(String[] args) throws InterruptedException {
        ExampleThread t1= new ExampleThread(1);
        // 不能直接调用run();那样只是普通的方法
        // t1.run();
        // 正确做法：使用start()
            t1.start();
            Thread.sleep(1000);
    }
}
