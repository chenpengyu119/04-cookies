package com.yu.threadtutorial.threadstronger.execise.container;

import java.util.ArrayList;

/**
 * @author pengyu
 */
public class Container {

    private ArrayList list = new ArrayList<>();

   // ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private Object writeLock = new Object();


    /**
     * 写入锁
     */
    //Lock writeLock = readWriteLock.writeLock();

    /**
     * 读取锁
     */
    boolean isRead ;

    boolean isWriting = false;

    public void add(Object obj){
       synchronized (writeLock){
            while (isRead) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (isWriting) {
                try {
                    writeLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            isWriting = true;
            list.add(obj);
            System.out.println(Thread.currentThread().getName()+"----添加元素："+obj+"成功，当前集合size="+list.size());
            isWriting = false;
            writeLock.notifyAll();
        }
    }

    public Object get(int index){

        while (isWriting) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            isRead = true;
            System.out.println(Thread.currentThread().getName()+"-------读取:"+list.get(index));
            return list.get(index);
        }finally {
            isRead = false;
        }
    }

}
