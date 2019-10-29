package com.yu.demo1;

import java.nio.charset.IllegalCharsetNameException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestException {
    public static void main(String[] args) {

        try {
            Scanner input = new Scanner(System.in);
            System.out.println("第一个数：");
            int numA = input.nextInt();
            System.out.println("第二个：");
            int numB = input.nextInt();
            System.out.println(numA/numB);
        }catch (ArithmeticException e){
            System.out.println("除数不能为0");
        }catch (InputMismatchException e){
            System.out.println("输入类型与期待值不匹配，请输入有效参数");
        }catch (Exception e){
            System.out.println("不知名异常");
        } finally {
            System.out.println("程序结束");
        }

    }
}
