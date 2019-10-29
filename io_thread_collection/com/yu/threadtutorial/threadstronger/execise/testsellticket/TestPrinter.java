package com.yu.threadtutorial.threadstronger.execise.testsellticket;

import com.yu.threadtutorial.threadstronger.execise.printnum.Test;

import java.util.concurrent.ExecutorService;

/**
 * @author pengyu
 */
public class TestPrinter {

    static ExecutorService pool = Test.pool;

    public static void main(String[] args) {

        Printer p = new Printer();
        for (int i = 0; i < 3; i++) {
            final int j = i+1;
            pool.execute(() ->{
                Thread.currentThread().setName(String.valueOf(j));
                for (int i1 = 0; i1 < 30; i1++) {
                    p.printNum();
                }

                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

            });
        }

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pool.shutdown();

    }



}
