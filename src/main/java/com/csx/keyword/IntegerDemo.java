package com.csx.keyword;

import org.junit.Test;

import javax.sound.midi.Soundbank;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/03/09
 */
public class IntegerDemo {
    /**
     * 分析：通过查看Integer源码不难发现，Integer内部对-128到127的Integer对象做了
     * 缓存，也就是说-128到127间的Integer对象只要数值相同，那么必定是同一个对象
     */
    @Test
    public void testInteger(){
        Integer a=100;
        Integer b=100;
        Integer c=128;
        Integer d=128;
        // 结果为true
        System.out.println(a==b);
        // 结果为false
        System.out.println(c==d);
    }
}
