package com.yu.factory;

public class ShapeFactory {

    /**
     * 父类作返回值
     * @param string
     * @return
     */
    public static Shape create(String string){
        Shape s=null;
        if("Circle".equals(string)){
            s = new Circle();}
        return s;
    }

    /**
     * 父类作形参
     * @param shape
     */
    public static void show(Shape shape){
        shape.draw();
    }

}
