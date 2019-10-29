package com.yu.threadtutorial.testthreadstate;

/**
 * 测试线程状态
 * @author pengyu
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {

        ThreadState state = new ThreadState();

        Thread thread = new Thread(state);

        System.out.println("Create new Thread:"+thread.getState());

        thread.start();

        System.out.println("start the Thread:"+thread.getState());

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("wait for a moment (time):"+thread.getState());

        // 使当前线程等待，从而使新线程运行waitForever方法
        Thread.sleep(1000);

        System.out.println("waiting for a moment:"+thread.getState());

        state.notifyNow();

        System.out.println("wake up the thread:"+thread.getState());

        Thread.sleep(1000);

        System.out.println("Terminate the thread :"+thread.getState());


    }

}
