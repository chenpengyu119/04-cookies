package com.yu.demo1;

import java.util.Objects;

public class TestException2 {
    static Exception exception= new Exception("结束");
    public static void main(String[] args) {
        System.out.println(sum().getMessage());
    }
    static Exception sum(){
        int res = 0;
        try {
            System.out.println("try");

            System.out.println("msg:"+exception.getMessage());
            res = 1/0;


        }catch (Exception e){
            System.out.println("catch"+e.getMessage());
            return exception;

        }finally {
            System.out.println("i am finally");
        }
        return null;
    }
}
