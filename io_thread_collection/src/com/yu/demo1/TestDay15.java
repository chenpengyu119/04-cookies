package src.com.yu.demo1;

import src.com.yu.day08.Person;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author pengyu
 */
public class TestDay15 {
    public static void main(String[] args) {

        //redBlackTree();
        //demoIndexOf();
        testRemove();
    }


    /**
     * 测试indexOf()参数为null的情况
     */
    private static void demoIndexOf(){
        ArrayList<String> list1 = new ArrayList<>();
        list1.add(null);
        System.out.println(list1.indexOf(null));
    }

    /**
     * 测试contains
     */
    private void testContains(){
        new ArrayList<String>().contains("1");
    }

    /**
     * 测试remove
     */
    private static void testRemove(){
        ArrayList list = new ArrayList<>();
        System.out.println();
        for (int i=0;i<10;i++){
            list.add(i);
        }
        System.out.println();

        StringBuilder bf = new StringBuilder();



    }

    /**
     * 红黑树
     */
    static void redBlackTree(){
       /* TreeSet<String> tree = new TreeSet<>();
        // 添加
        tree.add("jack");
        ArrayList<String> list = new ArrayList<>();
        list.add("111");
        boolean isSuccess = tree.addAll(list);
        System.out.println(isSuccess);
        System.out.println(tree);*/

        Person person1 = new Person("zhangsan", 18, "男");
        Person person2 = new Person("lisi", 40, "女");
        Person person3 = new Person("wangwu", 30, "男");
        Person person4 = new Person("chenyu", 30, "男");
        TreeSet<Person> personTreeSet = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        // TreeSet存储自定义类型之前必须实现比较器
        personTreeSet.add(person3);
        personTreeSet.add(person1);
        personTreeSet.add(person2);
        personTreeSet.add(person4);

        System.out.println(personTreeSet);







    }



}


