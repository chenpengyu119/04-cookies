package com.yu.threadtutorial;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Condition实现多线程交替执行
 */
public class TestCondition {


    public static void main(String[] args) {
        PrintDemo p = new PrintDemo();

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<3;i++) {
                    p.printA(1);
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<3;i++) {
                    p.printB(1);
                }
            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<3;i++) {
                    p.printC(1);
                }
            }
        });
        threadA.start();
        threadB.start();
        threadC.start();
    }
}

class PrintDemo{
    Lock lock = new ReentrantLock();

    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();

    private Integer flag = 1;

    public void printA(int loop){

        try {
            // 加锁
            lock.lock();
            if (flag!=1){
                conditionA.await();
            }
            for (int i=0;i<loop;i++){
                System.out.println('A');
            }

            flag = 2;
            // 通知B
            conditionB.signal();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 释放锁
            lock.unlock();
        }
    }


    public void printB(int loop){

        try {
            // 加锁
            lock.lock();
            if (flag!=2){
                conditionB.await();
            }
            for (int i=0;i<loop;i++){
                System.out.println('B');
            }

            flag = 3;
            conditionC.signal();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public void printC(int loop){

        try {
            // 加锁
            lock.lock();
            if (flag!=3){
                conditionC.await();
            }
            for (int i=0;i<loop;i++){
                System.out.println('C');
            }

            flag = 1;
            conditionA.signal();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


}
