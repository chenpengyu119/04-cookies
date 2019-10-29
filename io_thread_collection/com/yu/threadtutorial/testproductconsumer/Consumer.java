package com.yu.threadtutorial.testproductconsumer;

/**
 * 消费者
 *
 * @author pengyu
 */
public class Consumer implements Runnable {
    private Goods goods;

    public Consumer() {
    }

    public Consumer(Goods goods) {
        this.goods = goods;
    }


    @Override
    public void run() {


        //开始消费
        int loop = 10;

            synchronized (goods) {
                for (int i = 0; i < loop; i++) {
         /*   if (!goods.flag) {
                try {
                    goods.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/

       //     if (goods.flag) {
                if (i== 2){

                        goods.notify();

                }

                    System.out.println(Thread.currentThread().getName() + "消费了" + goods.getBrand()
                            + "牌" + goods.getName());
           //     }
                goods.flag = false;
                }
          //      goods.notify();
        //    }
        }
    }
}
