package com.yu.threadtutorial;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * 测试Thread内置方法
 * @author pengyu
 */
public class ThreadMethod {

    public static void main(String[] args) {

        // 获取线程名
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread());
        Runnable target = new MyTask();
        Thread thread1 = new Thread(target);
        // 改名
        thread1.setName("dryThread1");

        thread1.setPriority(6);

        System.out.println(thread1.isAlive());


        ExecutorService singleThreadPool = LockDemo.singleThreadPool;
        singleThreadPool.submit(thread1);
        singleThreadPool.shutdown();


        System.out.println(thread1.isAlive());

        System.out.println(thread1.getPriority());

    }


    static class MyTask implements Runnable{
        /**
         * 魔法值：莫名出现的常量
         */

        String separator = "------------";
        @Override
        public void run() {
            System.out.println(Thread.currentThread());
            int loop = 10;
            for (int i=0;i<loop;i++){
                System.out.println(Thread.currentThread().getName()+separator+i);
            }
        }
    }
}
