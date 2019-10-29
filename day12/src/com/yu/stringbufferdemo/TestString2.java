package src.com.yu.stringbufferdemo;

import java.util.Scanner;

public class TestString2 {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("please input:");
        method2(input.next());


    }

    /**
     * 判断是否对称
     */
    static void method2(String str1){

        String front,rear;
        int len = str1.length();
        // 先判断奇偶
        if(true/*len%2==0*/){// 偶数
            front = str1.substring(0,len/2);
            rear = str1.substring(len/2+1,len);
            System.out.println("前："+front+"\t后："+new StringBuilder(rear).reverse().toString());
            System.out.println(front.equals(new StringBuilder(rear).reverse().toString()));
        }else {

        }

    }

    /**
     * 输出所有字串
     */






    static void method1(){
        // 构造方法
        String string ;
        char[] chars = {'h','e','l','l','o'};
        string = new String(chars);

        String str1 = new String(chars,2,2);
        System.out.println(str1); // ll

        // 获取指定元素
        System.out.println(string.charAt(1));  //  e

        // 输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。
        System.out.println("请输入字符:");
        String chars1 = "jack 520 rose? relly?";

        System.out.println(chars1);

        int letterCount = 0,spaceCount = 0,digitCount =0,others = 0;
        char[] chars2 = chars1.toCharArray();

        for (char c:chars2){
            if (Character.isLetter(c)){
                letterCount++;
            }else if (Character.isDigit(c)){
                digitCount++;
            }else if (Character.isSpaceChar(c)){
                spaceCount++;
            }else{
                others++;
            }
        }
        System.out.println("arr,len"+chars2.length);
        System.out.println("长度："+chars1.length()+"\n字母："+letterCount
                +"\t空格："+spaceCount+"\t数字："+digitCount+"其他："+others);
    }




}
