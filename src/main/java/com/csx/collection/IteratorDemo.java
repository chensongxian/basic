package com.csx.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-03-11
 */
public class IteratorDemo {
    public static void main(String[] args){
        Collection coll = new ArrayList();

        coll.add( "abc1");
        coll.add( "abc2");
        coll.add( "abc3");
        coll.add( "abc4");

        System.out.println(coll);

        //使用了Collection中的iterator()方法。调用集合中的迭代器方法，是为了获取集合中的迭代器对象。
        Iterator it1 = coll.iterator();

        while(it1.hasNext()){
            System.out.println(it1.next());
        }

        //for循环结束，Iterator变量内存释放，更高效
        for(Iterator it2 = coll.iterator();it2.hasNext();){
            System.out.println(it2.next());
        }
    }
}
