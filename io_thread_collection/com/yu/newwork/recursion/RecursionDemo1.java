package com.yu.newwork.recursion;

import java.util.Arrays;

/**
 * 递归作业
 * 1. 计算阶乘
 * 2. 计算fibonaci数列第n项
 */
public class RecursionDemo1 {

    /**
     * 计算n的阶乘
     * @param n
     * @return
     */
    public int calcFac(int n) {
        if (n == 1) {
            return 1;
        }
        return calcFac(n-1)*n;
    }

    /**
     * 计算fibonacci数列第n项
     * 从第三项开始，每个数都是前两项之和
     */
    public int calcFibonacci(int n){
        if (n==1 || n==2) {
            return n;
        }
        return calcFibonacci(n-2)+calcFibonacci(n-1);
    }

    /**
     * 使用递归实现折半查找
     */
    public int binarySearchByRecursion(int num,int[] arr,int start,int end){
        int cursor = (start+end)>>1;
        if (num == arr[cursor]){
            return cursor;
        } else if ((start == end) && num == arr[start]){
            return   start;
        } else if ((start == end)&&(num != arr[cursor])) {
            return  -1;
        } else {
            if (arr[cursor] > num) {
                end = cursor - 1;
            } else if (arr[cursor] < num) {
                start = cursor + 1;
            }
            return binarySearchByRecursion(num, arr, start, end);
        }
    }

    /**
     * 不使用递归进行折半查找
     */
    public int binarySearch(int num,int[] arr){
        int start = 0;
        int end = arr.length-1;
        int cursor ;
        while (true) {
            cursor = (start+end)>>1;
            if (arr[cursor] == num){
                return cursor;
            }else if(start == end){
                if(arr[start] == num) {
                    return start;
                }else {
                    return -1;
                }
            }else {
                if (arr[cursor] > num){
                    end = cursor-1;
                }else if(arr[cursor] < num){
                    start = cursor + 1;
                }
            }
        }
    }

    /**
     * 测试
     */
    public static void main(String[] args) {
        RecursionDemo1 tester = new RecursionDemo1();
        int res = tester.calcFac(10);
        System.out.println(res);

        res = tester.calcFibonacci(6);
        System.out.println(res);

        int[] arr = {6,2,8,4,5,9,13,15,0};
        Arrays.sort(arr);
        System.out.println("排序："+Arrays.toString(arr));
        res = tester.binarySearchByRecursion(8, arr, 0, arr.length-1);
        System.out.println("查找结果:"+res);

        res = tester.binarySearch(8, arr);
        System.out.println("不使用递归，查找结果："+res);
    }

}
