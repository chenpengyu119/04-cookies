package com.yu.newwork.recursion.connection;

import java.util.HashSet;
import java.util.Objects;
import java.util.TreeSet;

/**
 * 集合练习题
 * @author pengyu
 */
public class Test002 {

    /**
     * 2.	使用HashSet和TreeSet存储多个商品信息，遍历并输出；
     * 其中商品属性：编号，名称，单价，出版社；
     * 要求向其中添加多个相同的商品，验证集合中元素的唯一性。
     * 提示：向HashSet中的键添加自定义类的对象信息，需要重写hashCode和equals( )
     * 	 向TreeSet中添加自定义类的对象信息，需要实现Comparable接口，指定比较规则
     */
    static class Goods implements Comparable{
        private String num;
        private String name;
        private double price;
        private String publisher;

        public Goods() { }

        public Goods(String num, String name, double price, String publisher) {
            this.num = num;
            this.name = name;
            this.price = price;
            this.publisher = publisher;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Goods goods = (Goods) o;
            return Double.compare(goods.price, price) == 0 &&
                    num.equals(goods.num) &&
                    name.equals(goods.name) &&
                    publisher.equals(goods.publisher);
        }

        @Override
        public int hashCode() {
            return Objects.hash(num, name, price, publisher);
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getPublisher() {
            return publisher;
        }

        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }

        @Override
        public String toString() {
            return "Goods{" +
                    "num='" + num + '\'' +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    ", publisher='" + publisher + '\'' +
                    '}';
        }

        @Override
        public int compareTo(Object o) {
            Goods goods = (Goods)o;
            return this.num.compareTo(goods.num);
        }
    }

    static void test1(){
        // HashSet
        HashSet<Goods> set = new HashSet<>();
        int loop = 5;

        Goods goods1 = new Goods("0001", "远大前程", 20.0, "中国人民出版社");
        Goods goods4 = new Goods("0001", "远大前程", 20.0, "中国人民出版社");
        Goods goods2 = new Goods("0002", "百年孤独", 30.0, "人民公社");
        Goods goods3 = new Goods("0003", "双城记", 50.0, "新华社");

        set.add(goods1);
        set.add(goods2);
        set.add(goods3);
        set.add(goods4);

        set.forEach(v-> System.out.println(v));

        TreeSet treeSet = new TreeSet();


    }

    public static void main(String[] args) {
        test1();
    }



}
