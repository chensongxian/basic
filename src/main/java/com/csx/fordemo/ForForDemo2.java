package com.csx.fordemo;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: csx
 * @Date: 2018-09-20
 */
public class ForForDemo2 {
    public static void main(String[] args) {
        for(int x=1;x<=9;x++){
            for(int y=1;y<=x;y++){
                System.out.print(y+"*"+x+"="+(x*y)+"\t");
            }
            System.out.println();
        }
    }
}
