package com.yu.threadtutorial.threadstronger.execise.print;

/**
 * 测试类
 * @author pengyu
 */
public class Test {

    public static void main(String[] args) {
        Printer p = new Printer();


        NumberPrinter numberPrinter = new NumberPrinter(p);

        LetterPrinter letterPrinter = new LetterPrinter(p);

        new Thread(numberPrinter).start();

        new Thread(letterPrinter).start();

    }

}
