package com.csx.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-03-11
 */
public class HashSetDemo {
    /**
     * 内部数据结构是哈希表，是不同步的
     * @param args
     */
    public static void main(String[] args){

        Set hs = new HashSet();

        hs.add( "hahah");
        hs.add( "heihei");
        hs.add( "hehe");
        hs.add( "xixi");

        Iterator it = hs.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
