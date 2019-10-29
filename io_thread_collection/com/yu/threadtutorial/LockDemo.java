package com.yu.threadtutorial;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试JUC中的ReentrantLock（可重入锁） 进行加锁
 * 注意：线程资源必须通过线程池提供，不允许在程序中自行显式创建线程
 * 使用线程池的好处是减少在创建和销毁线程上所花的时间以及系统资源的开销。解决资源不足的问题。
 * @author pengyu
 */
public class LockDemo {
    private static ReentrantLock lock = new ReentrantLock();

    /**
     * 通过实现接口，避免占用继承这个资源，因为java是单继承，如果通过继承， 无异于浪费了继承的资源。
     */
    public static class MyTask1 implements Runnable{

        @Override
        public void run() {
            // 调用ReentrantLock的加锁方法
            int loop = 3;
            for (int i=0;i<loop;i++) {
                lock.lock();
                try {
                    // 需要同步的代码块
                    System.out.println("线程1加锁");
                } finally {
                    // 必须在finally中解锁，否则可能造成死锁
                    lock.unlock();
                    System.out.println("线程1解锁");
                }
            }
        }
    }

    public static class MyTask2 implements Runnable{

        @Override
        public void run() {
            // 调用ReentrantLock的加锁方法
            int loop = 3;
            for (int i = 0;i<loop;i++) {
                lock.lock();
                try {
                    // 需要同步的代码块
                    System.out.println("线程2加锁");
                } finally {
                    // 必须在finally中解锁，否则可能造成死锁
                    lock.unlock();
                    System.out.println("线程2解锁");
                }
            }
        }
    }


    /**
     * 最近阿里发布的 Java开发手册中强制线程池不允许使用 Executors 去创建，而是通过 ThreadPoolExecutor 的方式，
     *     这样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。 其中ThreadFactoryBuilder需要用到google提供的guava包
     */
    /**
     * 线程名格式
     */
    static String nameFormat = "demo-pool-%d";
    /**
     *  定义工厂
     */
    static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat(nameFormat).build();

    /**
     * @param1 线程池大小
     * @param2 最大线程数量
     * @param3 超过线程池大小的空闲线程多久会被销毁
     * @param4 存活时间的单位
     * @param5 队列
     * @param6  拒绝策略，任务太多来不及处理时的拒绝策略
     */
    static ExecutorService singleThreadPool = new ThreadPoolExecutor(2,Integer.MAX_VALUE,60L,TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(1024),namedThreadFactory,
            new ThreadPoolExecutor.AbortPolicy());
    public static void main(String[] args) {

        MyTask1 myTask1 = new MyTask1();
        MyTask2 myTask2 = new MyTask2();




        singleThreadPool.submit(myTask1);
        singleThreadPool.submit(myTask2);
        singleThreadPool.shutdown();
        //thread1.start();
        //thread2.start();

    }

}
