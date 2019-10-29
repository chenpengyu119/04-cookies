package src.com.yu.stringbufferdemo;

import java.util.Enumeration;

import static src.com.yu.stringbufferdemo.EnumGender.男;

public class DemoBuffer {
    public static void main(String[] args) {
        StringBuilder bf = new StringBuilder();
        bf.append(1);
        System.out.println(bf.toString());
        bf.setCharAt(0,'a');
        System.out.println(bf);
        EnumGender e = EnumGender.女;
        switch (e){
            case 男:
                break;
        }
       // Enumeration
        /**
         * enum是枚举,是一个类.
         * Enumeration 是接口.
         */
    }
}

 enum EnumGender{
    男,女;
}
