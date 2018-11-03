package com.csx.fordemo;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: csx
 * @Date: 2018-09-20
 */
public class ForForDemo {
    public static void main(String[] args) {
        for(int x = 1; x<=5;x++){
            for(int y=1;y<=x;y++){
                System.out.print(x);
            }
            System.out.println();
        }
    }
}
