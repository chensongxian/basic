package com.csx.byteTest;

import org.junit.Test;

/**
 * @author csx
 * @Package com.csx.byteTest
 * @Description: TODO
 * @date 2018/11/6 0006
 */
public class ByteTest {

    /**
     *
     * java中负数二进制，最高位为符号位，打印的是负数的补码（原码的反码+1）
     */
    @Test
    public void testTrueForm() {
        int a = 134;
        int b = -a;
        System.out.println("正数：" + Integer.toBinaryString(a));
        System.out.println("负数：" + Integer.toBinaryString(b));
    }

    /**
     *
     * 最大值：01111111 ，最高位为符号位，为0
     * 最小值：10000000
     */
    @Test
    public void test2() {
        byte maxValue = Byte.MAX_VALUE;
        byte minValue = Byte.MIN_VALUE;
        System.out.println(Integer.toBinaryString(maxValue));
        System.out.println(Integer.toBinaryString(minValue));
    }
}
