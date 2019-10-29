package com.yu.threadtutorial;

import java.util.concurrent.ArrayBlockingQueue;

/**
 *  ArrayBlockingQueue 是由数组支持的有界阻塞队列。位于java.util.concurrent包下。
 *  入队常用方法：
 *
 * 入队方法	 队列已满	队列未满
 * add	    抛出异常	返回 true
 * offer	返回 false	返回 true
 * put	    阻塞直到插入	没有返回值
 * 出队常用方法
 *
 * 出队方法	 队列为空	队列不为空
 * remove	抛出异常	移出并返回队首
 * poll	   返回 null	移出并返回队首
 * take	  阻塞直到返回	移出并返回队首
 *
 * 应用于生产者消费者模型，当队满时生产者线程会等待队列可用
 * @author pengyu
 */
public class ABQDemo {

    private static ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {

        Runnable target;
        Thread thread1 = new Thread(() -> {
            int loop = 11;
            for (int i = 1; i < loop; i++) {
                arrayBlockingQueue.add(i);
            }
        });
        thread1.start();
        try {
            // 等待线程1执行完毕
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            // 如果插入失败
            if(!arrayBlockingQueue.offer(11)) {
                System.out.println("插入元素11失败");
            }

            try {
                // 一直阻塞直到插入元素11为止，阻塞的不是主线程
                arrayBlockingQueue.put(11);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Thread thread2 = new Thread(() -> {
            Integer element;
            System.out.println("开始出队……");
            while ((element = arrayBlockingQueue.poll()) != null){
                System.out.println("\t"+element);
            }
        });

        thread2.start();





    }



}
