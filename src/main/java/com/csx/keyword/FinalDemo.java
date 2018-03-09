package com.csx.keyword;

import org.junit.Test;
import org.omg.CORBA.portable.ValueOutputStream;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: final
 * @Author: csx
 * @Date: 2018/03/09
 */
public class FinalDemo {
    @Test
    public void test1(){
        /*
         * final成员变量表示常量，只能被赋值一次，赋值后值不再改变(不包括引用对象的内容)
         */
        final int a=1;
//        a=2;
    }

    @Test
    public void test2(){
        /*
         * 如果final修饰一个引用类型时，则在对其初始化之后便不能再让其指向其他对象了，
         * 但该引用所指向的对象的内容是可以发生变化的。
         * 如下便是例子
         */
        final StringBuffer s=new StringBuffer("aa");
        s.append("xx");
        System.out.println(s);
    }
}
