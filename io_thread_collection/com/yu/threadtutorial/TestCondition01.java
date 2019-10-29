package com.yu.threadtutorial;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition与ReentrantLock绑定使用
 * 用于通信
 * @author pengyu
 */
public class TestCondition01 {

    static class ReentrantLockCondition implements Runnable {
        public static ReentrantLock lock = new ReentrantLock();

        /**
         * 绑定
         */
        public static Condition condition = lock.newCondition();

        @Override
        public void run() {
            lock.lock();

            try {// 阻塞等待
                condition.await();
                System.out.println("Thread is going on");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }

        public static void main(String[] args) {
            ReentrantLockCondition t1 = new ReentrantLockCondition();
            Thread thread = new Thread(t1);
            thread.start();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 通知线程1继续执行，condition.signal方法调用时必须先获得相关锁
            lock.lock();
            condition.signal();
            lock.unlock();

        }
    }
}
