package com.yu.threadtutorial.stronger.productandconsumer;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品生产工厂
 *
 * @author pengyu
 */
public class GoodsFactory {

    private List<String> list = new ArrayList<>();

    public synchronized void product(String name) {

        // 这里不能使用if，因为if是执行一次，while是循环，每次都会重新进行判断
        /*while (list.size() == 10) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/

        list.add(name);
        System.out.println(Thread.currentThread().getName() + "生产商品:" + name + ",当前商品数量：" + list.size());
        notify();
    }

    public synchronized void consume(String name) {
        int loop = 10;
        int i1 = 0;
        /*while (list.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        list.remove(0);
        System.out.println(Thread.currentThread().getName() + "消费商品:" + name + ",当前商品数量：" + list.size());
        notify();
    }
}
