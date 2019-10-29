package com.yu.generic;

class Test1<T>{

    private T ob;
    /*
    定义泛型成员变量，定义完类型参数后，可以在定义位置之后的方法的任意地方使用类型参数，就像使用普通的类型一样。
    注意，父类定义的类型参数不能被子类继承。
    */

    // 构造方法
    public Test1(T ob){
        this.ob = ob;
    }

    // get方法
    public T getOb(){
        return ob;
    }

    // set方法
    public void setOb(T ob){
        this.ob = ob;
    }

    public void showType(){
        System.out.println("T的实际类型是hi："+ob.getClass().getName());
    }
}


public class TestDemo {
    public static void main(String[] args) {
        // 定义泛型Test的一个Integer版本
        Test1<Integer> intOb = new Test1<>(88);
        intOb.showType();
        int i = intOb.getOb();
        System.out.println("value:"+i);
        System.out.println("-----------------------");
        // 定义一个String版本的
        Test1<String> strOb = new Test1<>("Hello Genl");
        strOb.showType();
        String s = strOb.getOb();
        System.out.println("value:"+s);

    }
}














