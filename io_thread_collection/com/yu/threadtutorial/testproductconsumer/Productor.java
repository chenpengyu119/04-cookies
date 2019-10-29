package com.yu.threadtutorial.testproductconsumer;

/**
 * 生产者
 *
 * @author pengyu
 */
public class Productor implements Runnable {
    private Goods goods;

    public Productor() {
    }

    public Productor(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {

        int loop = 10;


            synchronized (goods) {

                for (int i = 0; i < loop; i++) {
            /*if (goods.flag){
                try {
                    goods.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }*/
        //    if (!goods.flag) {

                    // 没有商品，可以生产

                    if (i == 2) {
                        goods.setBrand("哇哈哈");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        goods.setName("饮料");

                            goods.notify();


                    } else {
                        goods.setBrand("旺仔");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        goods.setName("小馒头");
                    }

                    System.out.println(Thread.currentThread().getName() + "生产了" + goods.getBrand() + "牌" + goods.getName());

                // 生产结束

            //        goods.flag = true;

                  //  goods.notify();


        //    }
            }
        }
    }
}
