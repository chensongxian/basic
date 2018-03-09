package com.csx.exception;

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
            throwExcetion();
            a+=10;
            System.out.println(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void throwExcetion() throws Exception {
        try {
            throw new Exception("测试抛出异常");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
