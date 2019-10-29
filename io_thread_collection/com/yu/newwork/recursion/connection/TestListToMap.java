package com.yu.newwork.recursion.connection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Lisp和Map转换
 * @author pengyu
 */
public class TestListToMap {

    static class Student{

        private int id;
        private String name;
        private int age;
        private String sex;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        static ArrayList<Student> list = new ArrayList<>();

        public Student() {
            Student stu1 = new Student(001, "jack", 18, "男");
            Student stu2 = new Student(002, "rose", 18, "女");
            Student stu3 = new Student(003, "marry", 18, "男");
            Student stu4 = new Student(004, "jams", 18, "女");
            Student stu5 = new Student(005, "jom", 18, "男");
            list.add(stu1);
            list.add(stu2);
            list.add(stu3);
            list.add(stu4);
            list.add(stu5);
        }

        public Student(int id, String name, int age, String sex) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        /**
         * 定义方法public void listToMap( ){ }将List中Student元素封装到Map中
         */
        public  void listToMap() {
            Map<Integer,Student> map = new HashMap();
            for (Student s: list) {
                map.put(s.getId(), s);
            }
            Set<Map.Entry<Integer,Student>> entrySet = map.entrySet();
            for (Map.Entry<Integer,Student> entry:entrySet ) {
                System.out.println(entry);
            }
        }

        public static void main(String[] args) {
            Student student = new Student();
            student.listToMap();
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", sex='" + sex + '\'' +
                    '}';
        }
    }



}
