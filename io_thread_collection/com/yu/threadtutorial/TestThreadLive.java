package com.yu.threadtutorial;

/**
 * 线程生命周期
 * 线程操作方法
 * setDaemon()  设置为守护线程
 * 必须在线程启动之前设置
 * 当用户线程全部结束，整个应用程序就都结束了。
 * @author pengyu
 */
public class TestThreadLive {

    static class DaemonThread implements Runnable{

        @Override
        public void run() {
            while (true){
                System.out.println("I am alive");
            }
        }
    }

    static class OtherThread implements Runnable{
        @Override
        public void run() {
            int loop = 5;
            for (int i=0;i<loop;i++) {
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Runnable run = new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<5;i++) {
                    System.out.println(Thread.currentThread().getName());
                }
            }
        };

        Thread testYield = new Thread(run);
        testYield.setName("yieldThread");
        testYield.start();
        Thread otherThread = new Thread(new OtherThread());
        otherThread.setName("otherThread");
        otherThread.start();
        int loop = 10;
        for (int i=0;i<loop;i++){
            if (i == 5){
                // 让让其他人,但是不放弃竞争资源
                //Thread.yield();
                // 让其他人插队，但是谦让的那个人不一定能抢到
                testYield.join();
            }
            System.out.println(Thread.currentThread().getName());
        }

        // 守护线程
        Thread daemonThread = new Thread(new DaemonThread());
        daemonThread.setDaemon(true);
        //daemonThread.start();
        Thread.sleep(2000);
    }

}


