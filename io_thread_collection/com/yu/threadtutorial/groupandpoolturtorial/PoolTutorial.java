package com.yu.threadtutorial.groupandpoolturtorial;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author pengyu
 * 线程池测试
 */
public class PoolTutorial {

    static class MyTask implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {

        MyTask task = new MyTask();

        String nameFormat = "demo-pool-%d";
        // 线程工厂
         ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat(nameFormat).build();
        // Executor扮演工厂的作用 ,使用ThreadPoolExecutor创建，明确内部实现
        ExecutorService service = new ThreadPoolExecutor(5, Integer.MAX_VALUE,60L,
                TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>(),namedThreadFactory,
                // 拒绝策略
                new ThreadPoolExecutor.AbortPolicy());
       // ExecutorService service = Executors.newFixedThreadPool(3);
        int loop = 10;
        for (int i= 0; i < loop; i++) {
            service.submit(task);
        }
        service.shutdown();
    }
}
