package src.com.yu.test;

import javassist.*;

/**
 * 测试使用javaassist创建一个新类
 *
 * @author Administrator
 */
public class Demo01 {
    public static void main(String[] args) throws Exception {
        // 获得类池
        ClassPool pool = ClassPool.getDefault();
        // 新建类
        CtClass cc = pool.makeClass("com.yu.bean.Emp");
        // 创建属性 这里的是源码级操作
        CtField c1 = CtField.make("private int empno=0;", cc);
        CtField c2 = CtField.make("private String name;", cc);
        cc.addField(c1);
        cc.addField(c2);
        CtMethod m1 = CtMethod.make("public int getEmpno(){return empno;}",cc );
        cc.addMethod(m1);
        // 构造器 传CtClass，
        CtConstructor ctConstructor = new CtConstructor(new CtClass[]{CtClass.intType,pool.get("java.lang.String")}, cc);
        ctConstructor.setBody("{this.empno = empno;this.name=name;}");
        cc.addConstructor(ctConstructor);
        cc.writeFile("e:/emacs_javaworkspace");
        System.out.println("生成成功");


    }

}
