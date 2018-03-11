package com.csx.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-03-11
 */
public class LinkedHashSetDemo {
    /**
     * 无序变有序，使用LinkHashSet
     * @param args
     */
    public static void main(String[] args){
        HashSet hs = new LinkedHashSet();

        hs.add( "hahaa");
        hs.add( "hehe");
        hs.add( "heihei");
        hs.add( "xixii");

        Iterator it = hs.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
