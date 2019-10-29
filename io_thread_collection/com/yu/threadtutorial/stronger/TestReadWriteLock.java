package com.yu.threadtutorial.stronger;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 测试读写锁的使用
 * 这是一个接口，实现类为ReentrantReadWriteLock    有两个方法
 * @author pengyu
 */
public class TestReadWriteLock {

    private static ReentrantLock lock = new ReentrantLock();

    private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private static Lock readLock = readWriteLock.readLock();

    private static Lock writeLock = readWriteLock.writeLock();

    private int value;

    public Object handleRead(Lock lock) throws InterruptedException {

        try {
            lock.lock();
            Thread.sleep(1000);
            return value;
        }finally {
            lock.unlock();
        }
    }

    public void handleWrite(Lock lock,int index) throws InterruptedException {
        try {
            lock.lock();
            Thread.sleep(1000);
            value = index;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final TestReadWriteLock demo = new TestReadWriteLock();
        Runnable readRunnable = new Runnable() {
            @Override
            public void run() {
                try {
  //                  demo.handleRead(lock);
                    demo.handleRead(readLock);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable writeRunnable = new Runnable() {
            @Override
            public void run() {
                try {
 //                  demo.handleWrite(lock, new Random().nextInt());
                    demo.handleWrite(writeLock, new Random().nextInt());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        long start = System.currentTimeMillis();
        Thread thread1 = null;
        Thread thread2 = null;
        for (int i = 0; i < 18; i++) {
            thread1 = new Thread(readRunnable);
            thread1.start();
        }

        for (int i = 18; i < 20; i++) {
            thread2 = new Thread(writeRunnable);
            thread2.start();
        }
        try {
            //Thread.sleep(20*1000);
            Thread.sleep(3*1200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (thread1.isAlive() == false & thread2.isAlive() == false) {
            System.out.println(System.currentTimeMillis() - start);
            break;
        }

    }





}
