package com.yu.threadtutorial.threadstronger.productandconsumebyblockingqueue;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * 消费者
 * 从队列中取出PCData对象
 * @author pengyu
 */
public class Consumer implements Runnable{
    private BlockingQueue<PCData> queue ;                 // 缓冲区

    private static final int SLEEPTIME = 1000;

    public Consumer(BlockingQueue<PCData> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        System.out.println("start Consumer id = "+Thread.currentThread().getId());

        Random r = new Random();  // 随机等待时间

        try {
            while (true) {
                PCData data = queue.take();                    // 提取任务
                if (null != data) {
                    int re = data.getData() * data.getData();  //计算平方
                    System.out.println(MessageFormat.format("{0}*{1}={2}",
                            data.getData(),data.getData(),re));
                    System.out.println("队列长度"+queue.size());
                    Thread.sleep(r.nextInt(SLEEPTIME));
                }

            }
        }catch (InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

    }
}
