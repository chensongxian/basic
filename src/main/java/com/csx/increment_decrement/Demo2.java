package com.csx.increment_decrement;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: csx
 * @Date: 2018-09-20
 */
public class Demo2 {
    public static void main(String[] args) {
        int x = 4;
        int y = (x++)+(++x)+(x*10);
        System.out.println(y);
    }
}
