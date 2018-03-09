package com.csx.math;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/03/09
 */
public class MathDemo {
    /**
     * Math.round(11.4)相当于Math.floor(11.4+0.5)
     * 也就是把数值加0.5之后向下取整
     */
    @Test
    public void testMathRound(){
        float a=Math.round(11.4);
        float b=Math.round(-11.5);
        System.out.println(a);
        System.out.println(b);
    }
}
