package com.yu.threadtutorial.threadstronger.productandconsumebyblockingqueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 构建PCData对象，放入队列
 *
 * @author pengyu
 */
public class Producter implements Runnable {

    private volatile boolean isRunning = true;
    private BlockingQueue<PCData> queue;                       // 内存缓冲区
    private static AtomicInteger count = new AtomicInteger();  // 总数，原子操作
    private static final int SLEEPTIME = 1000;                 // 睡眠时间

    public Producter(BlockingQueue<PCData> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        PCData data = null;
        Random r = new Random();                                         // 随机等待时间

        System.out.println("start producter id ="+Thread.currentThread().getId());
        try {
            while (isRunning) {
                Thread.sleep(r.nextInt(SLEEPTIME));
                data = new PCData(count.incrementAndGet());             // 构造任务数据
                System.out.println(data + " is put into queue");
                System.out.println("队列长度"+queue.size());
                if (!queue.offer(data,2, TimeUnit.MILLISECONDS)) {  // 将数据提交到缓冲区
                    System.out.println("failed to put data" + data);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
    public void stop() {
        isRunning = false;
    }
}
