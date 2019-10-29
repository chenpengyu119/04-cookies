package com.yu.testhashmap;

import java.util.*;
import java.util.regex.Pattern;

/**
 * @author pengyu
 */
public class MapTest {
    /**
     * 用来承装课程对象
     */
    public Map<String, Course> courses;

    /**
     * 创建对象
     */
    public MapTest() {
        this.courses = new HashMap<>();
    }

    /**
     * 测试添加：输入课程ID，判断是否被占用，
     * 若未被占用，输入课程名，创建新课程对象
     * 并添加到courses中
     */
    public void testPut() {
        Scanner input = new Scanner(System.in);
        int loop = 3;
        for (int i = 0; i < loop; i++) {
            System.out.println("请输入课程id：");
            String id = input.next();
            Course cr = courses.get(id);
            if (cr == null) {
                System.out.println("课程名：");
                String name = input.next();
                Course newCourse = new Course(id, name);
                courses.put(id, newCourse);
                System.out.println("成功添加课程：" + courses.get(id).name);
            } else {
                System.out.println("该课程 ID已被占用");
                continue;
            }
        }

    }

    /**
     * 测试Map中的keySet()方法；获取所有键的集合
     */
    public void testKeySet() {
        Set<String> keySet = courses.keySet();
        for (String key : keySet) {
            Course cr = courses.get(key);
            if (cr != null) {
                System.out.println("课程：" + cr.name);
            }
        }
    }

    /**
     * 测试删除map中的映射
     */
    public void testRemove() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入要删除的课程Id：");
            Pattern pattern;
            String id = scanner.next();
            Course cr = courses.get(id);
            if (cr == null) {
                System.out.println("该ID不存在");
                continue;
            }
            courses.remove(id);
            System.out.println("成功删除课程：" + cr.name);
            break;
        }
    }

    /**
     * 通过entrySet遍历Map
     */
    public void testEntrySet() {
        // 通过entrySet方法，返回map中所有键值对的Set
        Set<Map.Entry<String, Course>> entrySet = courses.entrySet();
        for (Map.Entry<String, Course> entry : entrySet) {
            System.out.print("取得键：" + entry.getKey() + "\t");
            System.out.println("对应值：" + entry.getValue().name);
        }
        courses.values();

    }

    /**
     * 利用put方法修改Map中已有映射
     */
    public void testModify() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("请输入要修改的课程id：");
            String id = input.next();
            Course cr = courses.get(id);
            if (cr == null) {
                System.out.println("该id对应课程不存在");
                continue;
            }
            System.out.println("当前id对应课程名为："+cr.name);
            System.out.println("新课程名：");
            String name = input.next();
            // 直接插入一个覆盖即可
            Course newCourse = new Course(id, name);
            courses.put(id, newCourse);
            System.out.println("修改成功");
            break;
        }
    }

    public static void main(String[] args) {
        MapTest test = new MapTest();
        test.testPut();
        test.testKeySet();
        test.testRemove();
        test.testModify();
        test.testEntrySet();
    }


}
