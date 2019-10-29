package com.yu.threadtutorial.stronger;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author pengyu
 */
public class TestReadWriteLock2 {

    private static ReentrantLock lock = new ReentrantLock();

    private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();

    private static Operator operator = new Operator();

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable(){
                // read
                @Override
                public void run() {
                    while (true){
                        operator.read();
                    }
                }
            }).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable(){
                @Override
                public void run() {
                    while (true) {
                        operator.wirte();
                    }
                }
            }).start();
        }


    }

    static class Operator{

        private void read(){
            readLock.lock();
            try {
                System.out.println(Thread.currentThread().getName()+"开始读……");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"读完毕……");
            }finally {
                readLock.unlock();
            }

        }


        private void wirte(){
            writeLock.lock();
            try {
                System.out.println(Thread.currentThread().getName()+"开始写……");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"写完毕");
            }finally {
                writeLock.unlock();
            }


        }



    }




}
