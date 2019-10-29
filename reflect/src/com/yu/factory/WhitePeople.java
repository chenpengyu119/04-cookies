package com.yu.factory;

/**
 * @author pengyu
 */
public class WhitePeople implements Human{


    @Override
    public void laugh() {
        System.out.println("白种人在笑");
    }

    @Override
    public void talk() {
        System.out.println("白种人在说话……");
    }
}
