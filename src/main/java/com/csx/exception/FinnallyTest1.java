package com.csx.exception;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: finnaly测试
 * @author: csx
 * @Date: 2018-11-03
 */
public class FinnallyTest1 {
    public static void main(String[] args) {
        System.out.println("final result:"+test5());
//        System.out.println(getMap().get("key"));
    }

    /**
     *
     * 输出结果：
     * try block
     * finally block
     * b>25,b = 100
     * final result:100
     *
     * 说明return语句已经执行了再去执行finally语句，不过并没有返回
     * 而是等finally语句执行完了才返回结果
     * @return
     */
    public static int test1() {
        int b = 20;
        try {
            System.out.println("try block");
            return b += 80;
        } catch (Exception e) {
            System.out.println("catch block");
        } finally {
            System.out.println("finally block");

            if (b > 25) {
                System.out.println("b>25,b = " + b);
            }
        }
        return b;
    }

    /**
     * 输出：
     * try block
     * return statement
     * finally block
     * final result:after return
     *
     * 上述结果更能说明try中的return语句先执行但没有立即返回，等finally执行结束后再等执行
     *
     * @return
     */
    public static String test11() {
        try {
            System.out.println("try block");
            return test12();
        } finally {
            System.out.println("finally block");
        }
    }

    public static String test12() {
        System.out.println("return statement");
        return "after return";
    }


    /**
     *
     * 输出结果：
     * try block
     * finally block
     * b>25,b = 100
     * final result:200
     *
     * 说明finally中的return语句直接返回，而不管try中是否有返回语句
     * 而且finally外面的return b；变成了不可达语句，编译会报错
     * @return
     */
    public static int test2() {
        int b = 20;
        try {
            System.out.println("try block");
            return b += 80;
        } catch (Exception e) {
            System.out.println("catch block");
        } finally {
            System.out.println("finally block");

            if (b > 25) {
                System.out.println("b>25,b = " + b);
            }

            return 200;
        }
//        return b;
    }

    /**
     *
     * 输出结果：
     * try block
     * finally block
     * b>25,b = 100
     * final result:100
     *
     * 如果finally中没有return语句覆盖返回值，那么原来的返回值不会因为finally里的修改而改变
     * @return
     */
    public static int test3() {
        int b = 20;
        try {
            System.out.println("try block");
            return b += 80;
        } catch (Exception e) {
            System.out.println("catch block");
        } finally {
            System.out.println("finally block");

            if (b > 25) {
                System.out.println("b>25,b = " + b);
            }

            b = 150;
        }
        return b;
    }

    /**
     * 输出:
     * finally
     *
     * 在此例子中 finally中的操作改变了return的值
     * @return
     */
    public static Map<String,String> getMap() {
        Map<String,String> map = new HashMap<>();

        map.put("key","init");

        try {
            map.put("key","try");
            return map;
        } catch (Exception e) {
            map.put("key","catch");
        } finally {
            map.put("key","finally");
            map = null;
        }
        return map;
    }

    /**
     *
     * 输出：
     * try block
     * catch block
     * finally block
     * b>25,b = 35
     * final result:85
     * @return
     */
    public static int test4() {
        int b = 20;
        try {
            System.out.println("try block");
            b = b / 0;
            return b += 80;
        } catch (Exception e) {
            b += 15;
            System.out.println("catch block");
        } finally {
            System.out.println("finally block");

            if (b > 25) {
                System.out.println("b>25,b = " + b);
            }

            b += 50;
        }
        return b;
    }

    /**
     *
     * 输出：
     * try block
     * catch block
     * finally block
     * b>25,b = 35
     * final result:35
     *
     * finally中对b的改变没有影响到catch中return值
     * 原因和try中的return值一样
     * @return
     */
    public static int test5() {
        int b = 20;
        try {
            System.out.println("try block");
            b = b / 0;
            return b += 80;
        } catch (Exception e) {
            System.out.println("catch block");
            return b += 15;
        } finally {
            System.out.println("finally block");

            if (b > 25) {
                System.out.println("b>25,b = " + b);
            }

            b += 50;
        }
//        return b;
    }
}
