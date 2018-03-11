package com.csx.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-03-11
 */
public class ConcurrentModDemo {
    /**
     * 在迭代器过程中，不要使用集合操作元素，容易出现异常：java.util.ConcurrentModificationException。
     * 可以使用Iterator接口的子接口ListIterator来完成在迭代中对元素进行更多的操作
     */
    @Test
    public void test1(){
        List list = new ArrayList();

        list.add( "abc1");
        list.add( "abc2");
        list.add( "abc3");

        System.out.println( "list:" + list);

        Iterator it = list.iterator();

        while(it.hasNext()){
            Object obj = it.next();

            if(obj.equals("abc2" )){
                list.add( "abc9");
                //删除可以使用下面操作
//                it.remove();
            } else{
                System.out.println( "next:" + obj);
            }
            System.out.println(list);
        }
    }

    /**
     * 使用list的特有ListIterator迭代器
     */
    @Test
    public void test2(){
        List list = new ArrayList();

        list.add( "abc1");
        list.add( "abc2");
        list.add( "abc3");

        System.out.println( "list:" + list);

        ListIterator it = list.listIterator(); //获取列表迭代器对象
        //它可以实现在迭代过程中完成对元素的增删改查。
        //注意：只有list集合具备该迭代功能。

        while(it.hasNext()){
            Object obj = it.next();

            if(obj.equals("abc3" )){
                it.add( "abc9");
            }
        }

        System.out.println( "hasNext:" + it.hasNext());
        System.out.println( "hasPrevious:" + it.hasPrevious());

        while(it.hasPrevious()){
            System.out.println( "previous:" + it.previous());
        }
        System.out.println( "list:" + list);
    }
}
