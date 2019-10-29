package com.yu.threadtutorial;

/**
 * 线程中断:向线程发送通知，表明有人希望它退出，但是目标线程接到通知之后如何处理，
 * 需要在目标线程中进行相关设置处理。如果没有相关处理，即使设置中断也没有作用
 *
 */
public class TestThreadInterrupt {

    static class TestThread implements Runnable {
        @Override
        public void run() {
            System.out.println("i am alive");
            while (true) {
                // 如果发生中断后要进行的处理。
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Interrupt");
                    break;
                }
                try {
                    Thread.sleep(2000);
                    // 该异常在休眠时发生中断后会出现
                }catch (InterruptedException e) {
                    System.out.println("Interrupted When sleep");
                    // 设置中断状态
                    // 如果不在这里再次设置中断。上面将无法遇到中断情况
                    Thread.currentThread().interrupt();
                }
                Thread.yield();
            }
        }
    }


    public static void main(String[] args) {

        TestThread testThread = new TestThread();

        Thread thread = new Thread(testThread);

       /* ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        ExecutorService singleThreadPool = new ThreadPoolExecutor(1, Integer.MAX_VALUE, 50L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024),namedThreadFactory,new ThreadPoolExecutor.AbortPolicy());

        singleThreadPool.execute(thread);*/

       thread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 线程中没有做处理，不起作用
        thread.interrupt();


    }


}
