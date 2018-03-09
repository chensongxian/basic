package com.csx.extend;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/03/09
 */
public class TestInitialize {
    /**
     * 初始化顺序
     *
     * 父类静态代码块
     * 子类静态代码块
     * 父类构造代码块
     * 父类构造方法
     * 子类代码块
     * 子类构造方法
     *
     * @param args
     */
    public static void main(String[] args) {
        Student student=new Student();
    }
}
