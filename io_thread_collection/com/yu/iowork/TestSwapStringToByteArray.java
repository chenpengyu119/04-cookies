package com.yu.iowork;

/**
 * 2.	实现字符串和字节数组之间的相互转换。必如将字符串“北京尚学堂bjsxt”转换为字节数组，
 * 并将字节数组再转换回字符串。
 * @author pengyu
 */
public class TestSwapStringToByteArray {

    static byte[] swapStrToByteArray(String str) {
        return str.getBytes();
    }

    static String swapByteArrayToStr(byte[] bf){
        return new String(bf);
    }


}
