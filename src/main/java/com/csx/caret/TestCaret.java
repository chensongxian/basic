package com.csx.caret;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: csx
 * @Date: 2018-09-20
 */
public class TestCaret {
    public static void main(String[] args) {
        caret1();
        System.out.println("-----------");
        caret2();
    }

    public static void caret1(){
        int a = 5;
        int b = 3;
        a = a^b^b;
        System.out.println("a:"+a);
    }

    public static void caret2(){
        int a = 5;
        int b = 3;
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println("a:"+a+"--"+"b:"+b);
    }
}
