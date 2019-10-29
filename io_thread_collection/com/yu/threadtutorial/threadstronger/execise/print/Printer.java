package com.yu.threadtutorial.threadstronger.execise.print;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author pengyu
 */
public class Printer {

    ReentrantLock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();

    /**
     * 第几次打印
     */
    private volatile int index = 1;

    private boolean flag ;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public  void print(int i) {
        lock.lock();
        try {
            while (index%3 == 0) {
                try {
                    condition1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(i);
            index++;
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            condition2.signal();
        }finally {
            lock.unlock();
        }


    }

    /**
     *打印字母
     * @param c
     */
    public  void print(char c) {

        lock.lock();
        try {
            while (index%3 != 0) {
                try {
                    condition2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(c);
            index++;
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            condition1.signal();
        }finally {
            lock.unlock();
        }

    }



}
