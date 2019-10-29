package com.yu.threadtutorial.threadstronger.execise.printnum;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

public class Test {


    static String str = "demo-pool-%d";
    static ThreadFactory namedFactory = new ThreadFactoryBuilder().setDaemon(true).setNameFormat(str).build();
    public static ExecutorService pool = new ThreadPoolExecutor(3, Integer.MAX_VALUE, 60L, TimeUnit.MILLISECONDS
            ,new LinkedBlockingQueue<>(1024),namedFactory,new ThreadPoolExecutor.AbortPolicy());
    public static void main(String[] args) {

        Printer p = new Printer();



        pool.execute(() -> {
                Thread.currentThread().setName("1");
                for (int i = 0; i < 5; i++) {
                    p.print();
                }
        });



        pool.execute(() ->{
                Thread.currentThread().setName("2");
                for (int i = 0; i < 5; i++) {
                    p.print();
                }
        });

        pool.execute(() -> {
                Thread.currentThread().setName("3");
                for (int i = 0; i < 5; i++) {
                    p.print();
                }
        });


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pool.shutdown();

    }
}
