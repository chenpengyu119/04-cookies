package com.yu.threadtutorial;

/**
 * 继承Thread，重写run(); 通过start启动线程
 * 这个类会以另一个线程的方式运行run中的代码。
 */
public class ExampleThread  extends Thread{
    private int id;

    public ExampleThread() {
    }

    public ExampleThread(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        super.run();
        System.out.println(id+":this is a ExampleThread extending Thread");
    }
}
