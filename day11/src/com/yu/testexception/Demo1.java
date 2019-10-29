package com.yu.testexception;

/**
 * Throw和Throws
 */
public class Demo1 {
    // 声明异常，让调用者在使用时知道可能发生异常
    int divi(int a,int b) throws Exception{
        int res = 0;
        res = a/b;
        return res;
    }

    void demo1(){
        try {
            divi(1,2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * throw
     */
    void demo2(int a,int b){
        if(b==0){
            try {
                throw new Exception("除数为0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int res = a/b;
    }
}
