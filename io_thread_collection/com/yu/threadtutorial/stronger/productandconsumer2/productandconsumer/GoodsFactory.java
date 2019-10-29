package com.yu.threadtutorial.stronger.productandconsumer2.productandconsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 商品生产工厂
 *
 * @author pengyu
 */
public class GoodsFactory {

    private List<String> list = new ArrayList<>();

    private ReentrantLock lock = new ReentrantLock();

    private Condition productCondition = lock.newCondition();

    private Condition consumeCondition = lock.newCondition();



    public  void product(String name) {

        lock.lock();
        try {
            // 这里不能使用if，因为if是执行一次，while是循环，每次都会重新进行判断
            while (list.size() == 10) {
                try {
                    productCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            list.add(name);
            System.out.println(Thread.currentThread().getName() + "生产商品:" + name + ",当前商品数量：" + list.size());
            consumeCondition.signal();
        }finally {
            lock.unlock();
        }

    }

    public  void consume(String name) {

        lock.lock();

        try {
                int loop = 10;
                int i1 = 0;
                while (list.size() == 0) {
                    try {
                        consumeCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.remove(0);
                System.out.println(Thread.currentThread().getName() + "消费商品:" + name + ",当前商品数量：" + list.size());
                productCondition.signalAll();

        }finally {
            lock.unlock();
        }


    }
}
