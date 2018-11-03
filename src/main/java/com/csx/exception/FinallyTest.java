package com.csx.exception;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: finally测试
 * @Author: csx
 * @Date: 2018/03/09
 */
public class FinallyTest {
    public static void main(String[] args) {
        System.out.println(new FinallyTest().test2());
    }

    /**
     * 异常抛出后不再往下执行，但是一定会执行finally，
     * 所以最终输出结果是-1
     * @return
     */
    public int test1(){
        int x=1;
        try {
            int result=1/0;
            x++;
            return x;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return -1;
        }
    }


    /**
     * finally会执行，但不会影响return的结果
     * 返回2
     * @return
     */
    public int test2(){
        int x=1;
        try {
            int result=1/0;
            x++;
            return x;
        }catch (Exception e){
            x++;
            e.printStackTrace();
        }finally {
            x++;
            System.out.println("final:"+x);
//            return x;
        }
        return -1;
    }


    /**
     * 在finally里面return会影响return结果
     * 返回3
     * @return
     */
    public  int test3() {
        int x = 1;
        try {
//            int result=1/0;
            x++;
            return x;
        }catch (Exception e){
            x=5;
        } finally {
            ++x;
            System.out.println("final:"+x);
            return x;
        }
    }

}
