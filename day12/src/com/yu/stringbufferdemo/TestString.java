package src.com.yu.stringbufferdemo;

public class TestString {
    public static void main(String[] args) {
        StringBuffer bf = new StringBuffer();
        bf.append("helloworld");
        System.out.println(bf.capacity());

        bf.append("helloworldhelloworld!");

        System.out.println(bf.capacity());

        // toString
        System.out.println(bf);

        StringBuffer bf2 = new StringBuffer();
        bf2.append("helloworldhelloworldhelloworld!");

        // 比较地址
        System.out.println(bf.equals(bf2));

        //[start,end)
        bf = bf.delete(10,bf.length());
        System.out.println(bf);

        // 删除指定位置元素
        System.out.println(bf.deleteCharAt(2));

        // 增加
        System.out.println(bf.insert(2,'l'));

        // 逆序
        System.out.println(bf.reverse());

        // 字串
        System.out.println(bf+":"+bf.subSequence(1,3));

    }
}
