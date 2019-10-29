package com.yu.threadtutorial.threadstronger.execise.printnum;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author pengyu
 */
public class Printer {

    ReentrantLock lock = new ReentrantLock();

    Condition condition = lock.newCondition();

    private volatile int index  = 1;
    private volatile int loop = 1;
    public  void print(){
        lock.lock();

        try {
            String name= Thread.currentThread().getName();
            int nameInt = Integer.parseInt(name);
         //   if (!((index==3) && (nameInt==3))) {
                while (index % 3 != nameInt) {
                    if((index%3==0)&&(nameInt==3)){
                        break;
                    }
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
            }

            if (loop + 5 <66) {
                for(int i=loop;i<loop+5;i++) {
                    System.out.println(Thread.currentThread().getName() + ":" + i+"---------index:"+index);

                }
            }
            index++;
            loop+= 5;
            condition.signalAll();

        }finally {
            lock.unlock();
        }




    }
}
