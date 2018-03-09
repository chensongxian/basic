package com.csx.innerclass;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 成员内部类
 * @Author: csx
 * @Date: 2018/03/09
 */
public class Circle {
    private double radius = 0;
    private String desc="xx";
    public static int count =1;
    public Circle(double radius) {
        this.radius = radius;
        /*
         * 外部类访问内部类要先创建内部类对象，再通过指向这个对象的引用来访问
         */
        this.getDrawInstance().drawSahpe();
    }

    private Draw getDrawInstance() {
        return new Draw();
    }

    //内部类
    class Draw {
        /*
         * 非静态内部类不可以定义静态变量
         *
         * 非静态内部类是依附于外部类的，如果非静态内部类可以定义静态变量，那就意味着内部类脱离了外部类的掌控
         *
         * 但是非静态内部类是可以定义静态常量的，如下面的两个变量
         *
         */
        /**静态常量*/
        private static final int i=10;
        //静态变量，因为虽然s的引用时常量但是s的内容可变
//        private static final String s=new String("cc");
        private String desc;
        /**
         * 成员内部类可以无条件访问外部类的所有成员属性和成员方法（包括private成员和静态成员）
         */
        public void drawSahpe() {
            System.out.println(radius);  //外部类的private成员
            System.out.println(count);   //外部类的静态成员

            /*
             * 访问外部类同名成员或方法
             *
             * 外部类.this.成员变量
             * 外部类.this.成员方法
             */
            System.out.println(Circle.this.desc);
        }
    }

    public static void main(String[] args) {
        Circle circle=new Circle(10);

        Circle.Draw draw=circle.new Draw();


    }
}
