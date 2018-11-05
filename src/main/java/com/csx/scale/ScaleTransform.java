package com.csx.scale;

/**
 * @author csx
 * @Package com.csx.scale
 * @Description: 进制转换
 * @date 2018/11/5 0005
 */
public class ScaleTransform {
    public static void main(String[] args) {
//        System.out.println(toBinaryString(111));
        System.out.println(toOctalString(111));
    }

    /**
     * int二进制最大位数为32位
     */
    public static final int SIZE = 32;

    final static char[] digits = {
            '0' , '1' , '2' , '3' , '4' , '5' ,
            '6' , '7' , '8' , '9' , 'a' , 'b' ,
            'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
            'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
            'o' , 'p' , 'q' , 'r' , 's' , 't' ,
            'u' , 'v' , 'w' , 'x' , 'y' , 'z'
    };

    public static String toHexString(int i) {
        return toUnsignedString(i, 4);
    }

    public static String toOctalString(int i) {
        return toUnsignedString(i, 3);
    }

    public static String toBinaryString(int i) {
        return toUnsignedString(i, 1);
    }

    public static String toUnsignedString(int val, int shift) {
        int mag = SIZE - numberOfLeadingZeros(val);
        int chars = Math.max(((mag + (shift - 1)) / shift),1);
        char[] buf = new char[chars];

        formatUnsignedInt(val, shift, buf, 0, chars);

        // Use special constructor which takes over "buf".
        return new String(buf);
    }


    /**
     * 进制转换
     * @param val
     * @param shift
     * @param buf
     * @param offset
     * @param len
     * @return
     */
    static int formatUnsignedInt(int val, int shift, char[] buf, int offset, int len) {
        int charPos = len;
        // 1 << shift 相当于 1 * 2^shift,可得到相应的进制位，如1,3,4分别对应二、八、十六进制
        int radix = 1 << shift;
        // mask可以得到相应进制的最大位数
        int mask = radix - 1;
        do {
            // val & mask,可以取到val上的最后一位上的值
            buf[offset + --charPos] = ScaleTransform.digits[val & mask];
            // shift可以看做是各个进制位的一位在二进制上是几位，下面的操作是让val去掉最后一位，不断取最后一位的值
            val >>>= shift;
        } while (val != 0 && charPos > 0);

        return charPos;
    }

    /**
     * 计算首部零的位数，即从左边第一个位开始累加0的个数，直到遇到一个非零值
     * @param i
     * @return
     */
    public static int numberOfLeadingZeros(int i) {
        // HD, Figure 5-6
        if (i == 0)
            return 32;
        int n = 1;
        // i 往右无符号位移16 结果等于0，表明i的第一个非零值在低16位
        if (i >>> 16 == 0) {
            n += 16;
//            System.out.println(Integer.toBinaryString(i));
            i <<= 16;
//            System.out.println(Integer.toBinaryString(i));
//            System.out.println("------------------");
        }
        // i 往右无符号位移24 结果等于0，表明i的第一个非零值在高8位
        if (i >>> 24 == 0) {
            n +=  8;
//            System.out.println(Integer.toBinaryString(i));
            i <<=  8;
//            System.out.println(Integer.toBinaryString(i));
//            System.out.println("-------------------");
        }
        // i 往右无符号位移28 结果等于0，表明i的第一个非零值在高4位
        if (i >>> 28 == 0) {
            n +=  4;
//            System.out.println(Integer.toBinaryString(i));
            i <<=  4;
//            System.out.println(Integer.toBinaryString(i));
//            System.out.println("--------------------");
        }
        // i 往右无符号位移28 结果等于0，表明i的第一个非零值在高2位
        if (i >>> 30 == 0) {
            n +=  2;
//            System.out.println(Integer.toBinaryString(i));
            i <<=  2;
//            System.out.println(Integer.toBinaryString(i));
//            System.out.println("---------------------");
        }
//        System.out.println(Integer.toBinaryString(i>>>31));
        n -= i >>> 31;
        return n;
    }
}
