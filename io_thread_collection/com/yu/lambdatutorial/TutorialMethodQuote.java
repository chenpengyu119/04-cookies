package com.yu.lambdatutorial;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法引用
 * 可以通过方法名来引用本身
 * 通过::来描述
 * 可以引用以下类型方法：
 * 1. 无参构造方法。 Class::new
 * 2. 静态方法。Class::static_method
 * 3. 普通方法。Class::method
 * 4. 特定对象的方法。 instance_name ：method
 */
public class TutorialMethodQuote {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        names.add("Peter");
        names.add("Linda");
        names.add("Smith");
        names.add("Zack");
        names.add("Bob");
        // 引用了输出的方法
        names.forEach(System.out::println);

    }
}
