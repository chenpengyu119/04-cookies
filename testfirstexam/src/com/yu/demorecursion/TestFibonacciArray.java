package com.yu.demorecursion;

/**
 * fibonacci数列
 * n从0开始
 * @author pengyu
 */
public class TestFibonacciArray {

    /**
     * 求第多少位
     * 根据索引求取，第n位= 第n-1位+第n-2位
     * @param n
     * @return
     */
    private static int getFibonacci(int n) {
        if ( n==0 || n ==1) {
            return n;
        }
        return getFibonacci(n-1)+getFibonacci(n-2);
    }
    /**
     * 测试
     */
    public static void main(String[] args) {
        System.out.println(getFibonacci(7));
        // 第40位
        int fourtyth = getFibonacci(39);
        System.out.println("第40位："+getFibonacci(39));
    }

}
