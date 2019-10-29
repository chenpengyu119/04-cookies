package src.com.yu.interfacetest;

interface Impl1{
    /**
     * 静态常量
      */
    int NO = 0;
    String NAME = "";
    /**
     * 同名
     */
    void show();
/*    *//**
     * 静态方法
     *//*
    static void show1(){}
    *//**
     * default方法
     *//*
    default void show2(){}*/
}
interface Impl2{ }

abstract class  AbstractFather{
    /**
     * 重名
     * @param string 字符串
     */
    abstract void show(String string);
}

/**
 * @author Administrator
 */
public class Demo1  extends AbstractFather implements Impl1,Impl2{

    @Override
    public void show() {

    }

    @Override
    void show(String string) {

    }
}

