package com.csx.exception;

import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/03/09
 */
public class ExceptionTest {
    public static void main(String[] args) {
        new ExceptionTest().test();
    }

    /**
     * 抛出异常不会在往下执行
     *
     * 当异常被捕捉后仍然会往下执行
     */
    public void test(){
        try {
            int a=10;
//            runTimeException();
            runTimeExceptionCatch();
            a+=10;
            System.out.println("test结果："+a);
        } catch (Exception e) {
            System.err.println("test异常，" + e.getMessage());
        }

//        runTimeException();
    }

    /**
     *
     * 运行时异常，可以不用处理，虚拟机会处理 , 编译器不会提示你处理异常
     * IndexOutOfBoundsException  (数组越界异常)
     * ArithmeticException  (算术异常，比如除0)
     * ClassCastException  (类转换异常)
     * IllegalArgumentException  (非法参数异常)
     * ClassNotFoundException  (没有发现类异常)
     * NullPointException  (空指针异常)
     *
     */
    public void runTimeException() {
        throw new ClassCastException();
    }

    /**
     * 抛出运行时异常时，不捕获程序无法继续执行
     * 只有在调用方法中进行异常捕获才会继续往下执行
     * 
     */
    public void runTimeExceptionCatch() {
        try {
            throw new ClassCastException();
        } catch (RuntimeException e) {
            System.err.println("运行时异常捕获");
        }
    }
    public void throwExcetion() throws Exception {
        try {
            throw new Exception("测试抛出异常");
        } catch (Exception e) {
            System.err.println("throwExcetion异常");
        }
    }

    public void throwExceptionNoCatch() throws Exception {
        throw new Exception("非运行时异常");
    }
}
