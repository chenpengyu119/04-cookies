package com.yu.threadtutorial.callabletutorial;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Callable测试
 * @author pengyu
 */
public class CallableDemo {
    public static void main(String[] args) {
        CallableIml callableIml = new CallableIml();

        FutureTask task = new FutureTask<>(callableIml);

        System.out.println("是否已执行："+task.isDone());
        Thread t1 = new Thread(task);

        t1.start();

        try {
            System.out.println(task.get());
            System.out.println("是否已执行："+task.isDone());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
