package com.yu.threadtutorial.testthreadstate;

/**
 * 测试线程状态
 * 6种状态
 * 新建、运行（可运行 Runnable）、阻塞（Blocked）、计时等待（Timed Waiting）、等待（waiting）、终止（terminate）
 * @author pengyu
 */
public class ThreadState implements Runnable{
    /**
     * 计时等待
     * @throws InterruptedException
     */
    public synchronized void waitForAMoment () throws InterruptedException {
        wait(500);
    }

    /**
     * 等待
     * @throws InterruptedException
     */
    public synchronized void waitForever() throws InterruptedException {
        // 如果没有人notify将会一直等待下去
        wait();
    }

    public synchronized void notifyNow(){
        // 唤醒因为wait而进入等待的线程
        notify();
    }

    @Override
    public void run() {
        try {
            waitForAMoment();
            waitForever();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
