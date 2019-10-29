package src.com.yu.day08;

import src.com.yu.day08.Student;

public class Test {
    public static void main(String[] args) {
        // 会先执行父类的初始化块和父类的构造方法，然后再执行子类的初始化块和构造方法。
        Student stu= new Student("zhangsan",15,"man","101");
        stu.show();

        com.yu.day08.Teacher teacher=new com.yu.day08.Teacher("lisi",20,"female","10");
        teacher.show();

    }
}
