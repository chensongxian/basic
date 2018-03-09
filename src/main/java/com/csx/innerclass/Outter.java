package com.csx.innerclass;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/03/09
 */
public class Outter {
    private String outerDesc;
    private static String staticDesc;
    public Outter() {
        System.out.println("外部类");
    }

    public void printOutter(){
        System.out.println(new Inner().innerDesc);
        /*
         * 可直接引用静态内部类的静态变量
         */
        System.out.println(Inner.innerStatic);
    }


    static class Inner {
        public String innerDesc="静态内部类desc";
        public static String innerStatic="xxx";
        public Inner() {
            System.out.println("静态内部类");
        }

        public void printInner(){
            /*
             * 静态内部类和静态方法一样只能调用外部类的静态成员
             */
            System.out.println(staticDesc);
        }
    }

    public static void main(String[] args) {
        Outter outter=new Outter();
        outter.printOutter();
        //静态内部类可以不依赖于外部类
        Inner inner=new Inner();
    }
}
