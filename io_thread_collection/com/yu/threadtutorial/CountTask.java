package com.yu.threadtutorial;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * // 如果子任务处理长度不平衡，就会
 * @author pengyu
 */
public class CountTask extends RecursiveTask {

    /**
     * 阈值，小于阈值直接执行，不再分治
     */
    private static final int THRESHOLD = 10000;

    private long start;
    private long end;

    public CountTask(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {

        long sum  = 0;
        boolean canComputer = (end - start) < THRESHOLD;
        if (canComputer) {
            for (long i = start; i < end; i++) {
                sum += i;
            }
        }else {
            // 分成100个任务
            // 每个子任务的长度
            long step = (start + end) / 100;
            ArrayList<CountTask> subTasks = new ArrayList<>();
            // 子任务的起点
            long pos = start;
            int loop = 100;
            for(int i=0; i<loop; i++){
                // 子任务的末尾
                long lastOne = pos + step;
                // 如果子任务末尾超过了计算的终点，将子任务末尾设置为计算终点
                if (lastOne > end ){
                    lastOne = end;
                }
                CountTask subTask = new CountTask(pos, lastOne);
                // 起点前移子长度+1
                pos += step+1;
                subTasks.add(subTask);
                // 创建子任务的执行分支（线程）
                subTask.fork();
            }
            // 获取子任务返回值
            for(CountTask sub: subTasks){
                // 阻塞执行
                sub.join();
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        long start = System.currentTimeMillis();
        CountTask task = new CountTask(0L, 200000L);
        ForkJoinTask<Long> result = forkJoinPool.submit(task);

        try {
            long res = result.get();
            System.out.println(res);
            long end = System.currentTimeMillis();
            System.out.println("耗时："+(end - start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        forkJoinPool.shutdown();

    }

}
