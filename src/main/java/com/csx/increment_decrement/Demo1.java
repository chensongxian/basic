package com.csx.increment_decrement;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: csx
 * @Date: 2018-09-20
 */
public class Demo1 {
    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        int c = 10;

        int e = 0;

//        e = b++;
        System.out.println(e);

        e = ++b;
        System.out.println(e);

        int f = 0;
//        f = c--;
        f = --c;
        System.out.println(f);
    }
}
