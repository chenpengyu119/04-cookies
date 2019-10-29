package src.com.yu.demo1.drylinkedlist;

public class SimpleLinkedListTest {
    public static void main(String[] args) {
        SimpleLinkedList<String> list = new SimpleLinkedList<>();
        System.out.println("添加是否成功："+list.add("hello"));
        list.add(1, "world");
        System.out.println(list);
        // list.add(3, "outofbound");
        System.out.println("value:"+list.get(1));

        System.out.println("index"+list.indexOf("hello"));

        System.out.println("删除元素:"+list.remove(0));
        System.out.println("删除成功："+list.remove("world"));
        System.out.println("列表："+list);
    }
}
