package com.yu.lambdatutorial;

import com.yu.testhashmap.MapTest;

/**
 * lamda表达式
 * 先定义接口，在接口中定义抽象方法
 * 然后定义函数，函数类型为接口
 * 等号左边为lamda函数声明
 * 箭头左边为形参，参数类型可以省略，一个参数时括号可以省略
 * 箭头右边为方法体，一句的时候可以省略花括号
 * 函数调用: 可以直接通过lamda函数名.抽象方法名调用
 * 注意：Lambda表达式优先用于功能接口在行内实现，即单个方法只有一个接口。  意思就是一个接口只定义一个抽象方法，
 * 这样可以保证方法在一行内实现，如果定义成多个接口，无法在一行内实现所有方法。
 * Lambda表达式让匿名类不再被需要，增加了简洁但实用的函数式编程能力
 */
public class LamdbaTest {
    public static void main(String[] args) {
        LamdbaTest tester = new LamdbaTest();

        // 带有类型声明的表达式
        MathOperation addition = (int a, int b) -> {
            int i;
            i = a + b;
            return i;
        };

        // 没有类型声明
        MathOperation substaction = (a,b) -> a-b;
        // 等价于
        //MathOperation substraction = (int a,int b) -> {return a-b;};

        // 打印结果
        System.out.println(tester.operate(10, 3, addition));
        System.out.println(tester.operate(15, 4, substaction));

        // 定义函数  箭头前面是函数的形参，后面是函数体
        GreetService service1 = message -> System.out.println("Hello\t"+message);
        GreetService service2 = message -> System.out.println("Welcome To\t"+message);

        // 调用函数
        service1.syaMessage("moto");
        service2.syaMessage("Hongkong");

    } // main

    /**
     * 一些功能接口和方法
     */
    interface MathOperation{
        int operation(int a,int b);
    }

    interface GreetService{
        void syaMessage(String message);
    }

    private int operate(int a,int b,MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }


}
