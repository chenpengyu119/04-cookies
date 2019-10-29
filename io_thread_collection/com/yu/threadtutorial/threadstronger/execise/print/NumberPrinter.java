package com.yu.threadtutorial.threadstronger.execise.print;

/**
 * 打印数字
 * @author pengyu
 */
public class NumberPrinter extends Thread{

    private Printer p;

    public NumberPrinter(Printer p) {
        this.p = p;
    }

    @Override
    public void run() {
        for (int i = 1; i < 53; i++) {
            p.print(i);
        }

    }
}
