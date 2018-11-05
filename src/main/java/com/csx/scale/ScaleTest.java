package com.csx.scale;

/**
 * @author csx
 * @Package com.csx.scale
 * @Description: TODO
 * @date 2018/11/5 0005
 */
public class ScaleTest {
    public static void main(String[] args) {
        scalePreference();
        System.out.println("-------------");
        binaryTransform();
        System.out.println("-------------");
        // 二进制补码表示形式中最低（“最右”）的为 1 的位后面的零位个数
        System.out.println(Integer.numberOfTrailingZeros(12));
    }

    /**
     *
     * 不同进制在java中的表示
     */
    public static void scalePreference() {
        // 二进制
        int binaryNum = 0b110;
        System.out.println(binaryNum);

        // 八进制
        int octonaryNum = 011;
        System.out.println(octonaryNum);

        // 十进制
        int decimalNum = 789;
        System.out.println(decimalNum);

        // 十六进制
        int hexNum = 0xF;
        System.out.println(hexNum);
    }


    public static void binaryTransform() {
        int num = 6;
        String binaryNum = Integer.toBinaryString(num);
        System.out.println(binaryNum);
    }
}
