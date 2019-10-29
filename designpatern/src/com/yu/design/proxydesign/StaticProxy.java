package com.yu.design.proxydesign;

/**
 * 静态代理
 * 1. 真实角色
 * 2. 代理角色
 */
public class StaticProxy {
    public static void main(String[] args) {
        new WeddingCompany(new You()).happyMarry();


    }
}



interface Marry{
    void happyMarry();
}

class You implements Marry{

    @Override
    public void happyMarry() {
        System.out.println("you and 嫦娥终于奔月了");
    }
}

class WeddingCompany implements Marry{

    private Marry target;
    public WeddingCompany(Marry target){
        this.target = target;
    }

    @Override
    public void happyMarry() {
        ready();
        this.target.happyMarry();
        after();
    }

    private void ready(){
        System.out.println("布置猪窝");
    }

    private void after(){
        System.out.println("闹洞房");
    }
}
