package com.yu.threadtutorial;

/**
 * ThreadLocal，即线程变量，是一个以 ThreadLocal 对象为键、任意对象为值的存储结构。
 * 这个结构被附带在线程上，也就是说一个线程可以根据一个 ThreadLocal 对象查询到绑定在这个线程上的一个值。
 * 可以通过 set(T)方法来设置一个值，在当前线程下再通过 get()方法获取到原先设置的值。
 *
 * 作用:设置线程变量后，两个线程的变量就独立了，
 * 未设置线程变量的话，两个线程使用同一对象的值，integer成了线程共享变量，这在多线程环境下是不安全的，
 */
public class ThreadLoaclDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadDemo threadDemo = new ThreadDemo();
        //TODO: 使用线程池
        Thread t1 = new Thread(threadDemo);
        t1.start();


        new Thread(threadDemo).start();

    }

}

class ThreadDemo implements Runnable{

    /**
     *  使用ThreadLocal的静态方法创建一个线程一个线程变量，并且初始化为0
     */

    /*private static ThreadLocal<Integer> threadLocal
            = ThreadLocal.withInitial(()->0);*/
    private Integer integer = 0;

    @Override
    public void run() {
        for (int i=0;i<10;i++){
            // get方法获取线程变量值
           // Integer integer = threadLocal.get();
            integer += 1;
            // set设置线程变量值
            //threadLocal.set(integer);
            System.out.println(integer);
        }
    }
}
