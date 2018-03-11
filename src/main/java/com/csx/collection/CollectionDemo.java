package com.csx.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-03-11
 */
public class CollectionDemo {
    public static void main(String[] args){
        Collection coll = new ArrayList();
        show(coll);

        System.out.println( "---------------------------------" );

        Collection c1 = new ArrayList();
        Collection c2 = new ArrayList();
        show(c1,c2);
    }

    public static void show(Collection coll){
        //1、添加元素，add
        coll.add( "abc1");
        coll.add( "abc2");
        coll.add( "abc3");
        System.out.println( "coll:" + coll);

        //2、删除元素，remove
        coll.remove( "abc2");//会改变集合的长度
        System.out.println( "coll:" + coll);

        //清空集合
        //coll.clear();
        System.out.println(coll.contains( "abc1"));
    }

    public static void show(Collection c1,Collection c2){
        //给c1添加元素
        c1.add( "abc1");
        c1.add( "abc2");
        c1.add( "abc3");
        c1.add( "abc4");

        //给c2添加元素
        c2.add( "abc2");
        c2.add( "abc6");
        c2.add( "abc7");

        System.out.println( "c1:" + c1);
        System.out.println( "c2:" + c2);

        //演示addAll
        //将c2中的元素添加到c1中
        c1.addAll(c2);

        //演示removeAll
        //从c1集合中删除与c2集合相同的元素
        boolean b = c1.removeAll(c2);
        System.out.println( "removeAll:" + b);

        //演示containsAll
        boolean b1 = c1.containsAll(c2);
        System.out.println( "containsAll:" + b1);

        //演示retainAll
        //取交集，保留和指定的集合相同的元素
        boolean b2 = c1.retainAll(c2);
        System.out.println( "c1、c2交集:" + c1);
    }
}
