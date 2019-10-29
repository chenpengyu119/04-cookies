package com.yu.demorecursion;

/**
 * @author pengyu
 */
public class TestRecursion2 {

    public static void main(String[] args) {
        //调用fibo方法并输出结果（1分）
        int n = 40;
        TestRecursion2 test = new TestRecursion2();
        System.out.println(test.fibo(n));
    }
    public long fibo(int n){//定义递归方法（1分）
        //递归结束条件1：数列的第一个数是0(1分)
        if(n==1){
            return 0;
        }
        //递归的结束条件2：数列的第二个数是1（1分）
        if(n==2){
            return 1;
        }
        //使用递归技术第n个数（n>2）（1分）
        return fibo(n-1)+fibo(n-2);
    }

}
