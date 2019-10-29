package com.yu.threadtutorial.threadstronger.execise.testsellticket;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程打印递减数字，30-1
 * 不能重复，每个线程打印一个数字之后休眠，300毫秒，
 * 模拟多线程售票
 * @author pengyu
 */
public class Printer {

    ReentrantLock lock = new ReentrantLock();

    /**
     * 上限
     */
    private volatile int max = 30;

    /**
     * 打印数字
     */
    public void printNum(){
        try {
            lock.lock();

            //while (max > 0) {
            if (max > 0) {
                System.out.println(Thread.currentThread().getName() + "-------" + max--);

            }

        }finally {
            lock.unlock();
        }
    }


}
