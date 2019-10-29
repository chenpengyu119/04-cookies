package com.yu.threadtutorial.threadstronger.productandconsumebyblockingqueue;

/**
 * 生产者和消费者之间的数据共享模型
 * @author pengyu
 */
public class PCData {

    private final int intData;
    public PCData(int d){
        intData = d;
    }

    public PCData(String d) {
        intData = Integer.valueOf(d);
    }

    public int getData(){
        return intData;
    }

    @Override
    public String toString() {
        return "intData:" + intData;
    }
}
