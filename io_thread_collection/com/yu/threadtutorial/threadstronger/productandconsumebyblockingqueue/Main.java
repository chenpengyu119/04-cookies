package com.yu.threadtutorial.threadstronger.productandconsumebyblockingqueue;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * 创建三个生产者和三个消费者，协作运行，
 * @author pengyu
 */
public class Main {

    static String nameFormat = "demo-pool-%d";

    static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat(nameFormat).build();
    static ExecutorService singleThreadPool = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
            60L, TimeUnit.SECONDS,
            new SynchronousQueue<Runnable>(),namedThreadFactory,new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<PCData> queue = new LinkedBlockingQueue<>(10);
        // 建立生产者
        Producter producer1 = new Producter(queue);
        Producter producer2 = new Producter(queue);
        Producter producer3 = new Producter(queue);
        // 消费者
        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);
        Consumer consumer3 = new Consumer(queue);
        // 建立线程池

        singleThreadPool.execute(producer1);
        singleThreadPool.execute(producer2);
        singleThreadPool.execute(producer3);
        singleThreadPool.execute(consumer1);
        singleThreadPool.execute(consumer2);
        singleThreadPool.execute(consumer3);

        Thread.sleep(10*1000);

        producer1.stop();
        producer2.stop();
        producer3.stop();
        Thread.sleep(3000);
        singleThreadPool.shutdown();


    }
}
