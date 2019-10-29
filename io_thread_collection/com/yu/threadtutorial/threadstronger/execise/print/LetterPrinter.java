package com.yu.threadtutorial.threadstronger.execise.print;

/**
 * 打印字母
 * @author pengyu
 */
public class LetterPrinter extends Thread{

    private Printer p;

    public LetterPrinter(Printer p) {
        this.p = p;
    }

    @Override
    public void run() {
        for (int i = 65; i < 91; i++) {
            p.print((char)i);
        }
    }
}
