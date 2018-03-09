package com.csx.extend;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/03/09
 */
public class TestDemo extends Date{
    public static void main(String[] args) {
        new TestDemo().test();
        new TestDemo().test1();
    }

    /**
     *  Object中的getClass方法如下：
     *  // 返回此 Object 的运行时类
     *  public final native Class<?> getClass();
     *
     *  是final的，因此所有的类调用的getClass方法都是Object的getClass方法
     */
    public void test(){
        /*
         * 调用Date类中的getclass()方法，Date是Object的子类，Date中的getClass()是Object中的，
         * 运行时期的实例是TestDemo类，所以输出的依然是TestDemo
         */
        System.out.println(super.getClass().getName());
        /*
         * 调用TestDemo类中的getclass()方法，此方法从Date继承的，Date从Object继承的，
         * 运行时期的实例是TestDemo类，所以输出的是TestDemo
         */
        System.out.println(this.getClass().getName());
    }

    /**
     * 得到真正的父类名称
     */
    public void test1(){
        System.out.println(getClass().getSuperclass().getName());
    }
}
