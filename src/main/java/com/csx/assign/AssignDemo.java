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
//        b=b+1;
        // 不会报错，因为b+=1会在编译之后变成b=(byte)(b+1)
//        b+=1;
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


    @Test
    public void test4() {
        byte a = 3;
        byte b = 4;
        /*
         * 编译会报错，因为当运行过程中JVM是无法判断a和b的值得，byte类型的变量会在运算时自动提示为int类型
         */
//        byte c = a + b;
        // 不会报错，JVM中有常量优化机制，会在编译的时候直接把3+4的结果赋值给c
        byte c = 3 + 4;
//        System.out.println(c);
    }

    @Test
    public void test5() {
          double a = 0.753;
          // 编译会报错，因为java中小数默认为double类型，
          // 如果赋值给float会编译出错，要想赋值给float必须后面加f
          // float b = 0.753;
        float b = 0.753f;
    }
}
