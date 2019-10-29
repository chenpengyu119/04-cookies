package com.yu.lambdatutorial;

/**
 * lamda的作用域
 * 可访问 static 修饰的成员变量，如果是 final static 修饰，不可再次赋值，只有 static 修饰可再次赋值；
 * 可访问表达式外层的 final 局部变量（不用声明为 final，隐性具有 final 语义），不可再次赋值。
 */
public class ModifyLamdbaTest {
    /**
     * 正确，可再次赋值
     * @param args
     */
    static String salutation1 = "Hello";
    /**
     * 报错
     */
    String salutation2 = "Hello";

    /**
     * 正确，不能再赋值
     * @param args
     */
    final static String salutation3 = "Hello";

    public static void main(String[] args) {
        //final String salutation = "Hello "; //正确，不可再次赋值
        //String salutation = "Hello "; //正确，隐性为 final , 不可再次赋值

        ModifyLamdbaTest tester = new ModifyLamdbaTest();

        // 定义函数  箭头前面是函数的形参，后面是函数体
        GreetService service1 = message -> System.out.println(salutation1+"\t"+message);

        // 调用函数
        service1.syaMessage("moto");

    } // main

    /**
     * 功能接口
     */

    interface GreetService{
        void syaMessage(String message);
    }

}
