package com.yu.threadtutorial.futuremode;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * Future模式
 * 通过Future接口，可以获取真实数据，相当于契约
 * Runnable继承了Future和Runnable 两个接口，其中run方法用于构造真实数据
 * Future有一个具体实现类FutureTask.
 * FutureTask有一个Sync内部类，进行实质性工作，Sync最后调用Callable接口，进行实际数据
 * 的组装工作。
 * * @author pengyu
 */
public class TestCallable01 {

    static class RealData implements Callable{
        /**
         *空降兵
         */
        private String para;

        public RealData(String para) {
            this.para = para;
        }

        @Override
        public Object call() throws Exception {
            StringBuffer bf = new StringBuffer();
            for (int i = 0; i < 10; i++) {
                bf.append(para);
                Thread.sleep(100);
            }
            return bf.toString();
        }
    }

    public static void main(String[] args) {
        // 构造FutureTask
        FutureTask<String> future = new FutureTask<>(new RealData("a"));
        ThreadFactory namedFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        ExecutorService singleThreadPool = new ThreadPoolExecutor(2, Integer.MAX_VALUE,
                60L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>(1024),namedFactory,
                new ThreadPoolExecutor.AbortPolicy());
        singleThreadPool.submit(future);

        System.out.println("请求完毕");

        // 继续操作其他数据
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 如果此时call方法未执行完成，依然会等待,因为get方法是阻塞的
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
