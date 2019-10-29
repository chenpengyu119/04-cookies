package com.yu.threadtutorial.groupandpoolturtorial;

/**
 * 线程组
 * @author pengyu
 */
public class GroupTuturial {

    static class Thread1 implements Runnable{
        @Override
        public void run() {
            //Thread.currentThread().setName("线程1");
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        String name = "PrintGroup";
        ThreadGroup group1 = new ThreadGroup(name);
        Thread thread1 = new Thread(group1, new Thread1(), "线程1");
        Thread thread2 = new Thread(group1,new Thread1(),"线程2" );

        thread1.start();
        thread2.start();

        System.out.println(group1.activeCount());



    }
}
