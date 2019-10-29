package com.yu.threadtutorial.callabletutorial;

import java.util.concurrent.Callable;

/**
 * @author pengyu
 */
public class CallableIml implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(500);
        return "HelloWorld";
    }
}
