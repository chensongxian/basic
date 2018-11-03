package com.csx.assign;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 赋值时类型转换问题
 * @Author: csx
 * @Date: 2018/03/09
 */
public class AssignDemo {
    @Test
    public void test1(){
        byte b=10;
        b++;
        /*
         * 下面这句会报编译错误，因为b是byte类型当b和1相加之后结果变成了int类型,
         * 再赋值给b时就会报错
         */
        //b=b+1;
        System.out.println(b);
    }

    @Test
    public void test2(){
        short s=1;
        /*
         * 下面这句会报编译错误，原因和test1里面的原因相同
         */
        //s= s+1;
        /*
         * 下面这句不会报错，因为s+=1会在编译之后变成s=(short)(s+1)
         */
        s+=1;
    }


    @Test
    public void test3(){
        int min=Integer.MIN_VALUE;
        System.out.println(min);
    }

}
