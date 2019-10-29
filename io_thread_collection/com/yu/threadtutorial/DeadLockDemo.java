package com.yu.threadtutorial;

/**
 * 测试死锁
 * 在多线程环境下，锁的使用非常频繁，但是它会带来一下问题，比如死锁。
 * 当死锁发生时，系统将会瘫痪。比如两个线程互相等待对方释放锁。
 */
public class DeadLockDemo {

    private static Object lockA = new Object();
    private static Object lockB = new Object();


    public static void main(String[] args) {

        // 使用lamda表达式创建一个线程
        

    }

}
