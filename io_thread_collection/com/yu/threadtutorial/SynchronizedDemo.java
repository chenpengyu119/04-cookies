package com.yu.threadtutorial;

import java.io.ObjectInputStream;

/**
 * 对普通方法使用，将会锁住当前实例对象
 *     对静态方法使用，将会锁住当前类的 Class 对象
 *     对代码块使用，将会锁住代码块中的对象
 * @author pengyu
 */
public class SynchronizedDemo {
    // Object对象
    private static Object lock = new Object();

    public static void main(String[] args) {
        // 同步代码块锁住对象
        synchronized (lock){
            // 操作lock
        }
    }

    // 静态同步方法，锁住当前类class对象
    public synchronized static void staticMethod(){
        // 操作类
    }

    // 普通同步方法，锁住当前对象
    public synchronized void memberMethod(){
        // 操作当前对象
    }


}
