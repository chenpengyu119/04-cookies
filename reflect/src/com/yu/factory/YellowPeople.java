package com.yu.factory;

/**
 * @author pengyu
 */
public class YellowPeople implements Human{


    @Override
    public void laugh() {
        System.out.println("黄种人在笑");
    }

    @Override
    public void talk() {
        System.out.println("黄种人在说话……");
    }
}
