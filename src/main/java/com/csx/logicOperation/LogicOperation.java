package com.csx.logicOperation;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: csx
 * @Date: 2018-11-06
 */
public class LogicOperation {

    public static void main(String[] args) {
        // 有短路效果，当fisrtAnd返回false时不会执行secondAnd
        if (first() && second()) {
            System.out.println("&&成立");
        }
        System.out.println("-----------");
        if (first() & second()) {
            System.out.println("&成立");
        }

        System.out.println("--------");
        // firstAnd成立时，后面的secondAnd不会执行
        if (first() || second()) {
            System.out.println("||成立");
        }
        System.out.println("--------");
        // | 与 & firstAnd和secondAnd都会执行
        if (first() | second()) {
            System.out.println("|成立");
        }


    }

    public static boolean first() {
        System.out.println("first");
        return true;
    }

    public static boolean second() {
        System.out.println("second");
        return true;
    }
}
