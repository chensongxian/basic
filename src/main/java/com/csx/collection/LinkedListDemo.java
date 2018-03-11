package com.csx.collection;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-03-11
 */
public class LinkedListDemo {
    public static void main(String[] args){
        LinkedList link = new LinkedList();

        link.addFirst( "abc1");
        link.addFirst( "abc2");
        link.addFirst( "abc3");
        link.addFirst( "abc4");

        Iterator it = link.iterator();
        while(it.hasNext()){
            System.out.println( "next:" + it.next());
        }

        System.out.println(link);
        System.out.println("getFirst:" + link.getFirst()); //获取第一个，但是不删除。
        System.out.println("getLast:" + link.getLast());

        System.out.println("removeFirst:" + link.removeFirst()); //获取第一个，但是删除
        System.out.println("removeLast:" + link.removeLast());

        //删除所有元素的方法
        while(!link.isEmpty()){
            System.out.println(link.removeFirst());
        }
    }
}
