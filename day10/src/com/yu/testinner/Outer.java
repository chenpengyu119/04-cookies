package com.yu.testinner;

public class Outer {
    private String name = "lisi";
    /**
     * 成员内部类
     */
    class Inner{
        private String name;
        private void show(){
            name = "张三";
            System.out.println(name);
            String nameOuter = Outer.this.name;
            System.out.println(nameOuter);
        }
        public void show2(){
            System.out.println("show2");
        }
    }
    void run(){
        new Inner().show();
    }
}

class Demo{
    public static void main(String[] args) {
        // 通过外部类对象创建成员内部类的对象
        Outer.Inner inner = new Outer().new Inner();
        inner.show2();
        new Outer().run();
    }
}
