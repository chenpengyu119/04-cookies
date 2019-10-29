package src.com.yu.demo1;

/**
 * 测试SimpleArrayList
 */
public class SimpleArrayListTest {
    public static void main(String[] args) {

        SimpleArrayList<String> list = new SimpleArrayList<>();
        list.add("hello");
        list.add(1, "world");
        for (int i=0;i<9;i++){
            list.add(String.valueOf(i));
        }
        System.out.println(list);
        System.out.println(list.get(1));

        System.out.println(list.indexOf("he"));
        System.out.println(list.indexOf("hello"));

        System.out.println(list.contains("he"));
        System.out.println(list.contains("hello"));

        System.out.println(list.size());

        System.out.println(""+list.remove("he")+"\t"+list.size());
        System.out.println(""+list.remove("hello")+"\t"+list.size());
        System.out.println((""+list.remove(1)+"\t"+list.size()));




    }
}
