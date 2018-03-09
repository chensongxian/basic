package com.csx.extend;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/03/09
 */
public class Person {
    static {
        System.out.println("父类静态代码块");
    }

    {
        System.out.println("父类构造代码块");
    }

    public Person() {
        System.out.println("父类构造方法");
    }

}
