package com.yu.threadtutorial;

/**
 * 买票 同步资源的使用
 *  使用synchronized进行同步控制
 * @author pengyu
 */
public class TestSellTicket {
    private static int ticket = 5;

    static class SellTicket implements Runnable{

        @Override
        public void  run() {
            int loop = 100;
            for (int i = 0; i<loop; i++){
                synchronized (TestSellTicket.class) {
                    if (ticket > 0) {
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "is selling" + (ticket--) + "ticket");
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        SellTicket sellTicket = new SellTicket();
        Thread sellTicketThread1 = new Thread(sellTicket,"window1");
        Thread sellTicketThread2 = new Thread(sellTicket,"window2");
        Thread sellTicketThread3 = new Thread(sellTicket,"window3");

        sellTicketThread1.start();
        sellTicketThread2.start();
        sellTicketThread3.start();


    }
}
