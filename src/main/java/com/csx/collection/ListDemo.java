package com.csx.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-03-11
 */
public class ListDemo {
    public static void main(String[] args){
        List list = new ArrayList();
        show1(list);
    }

    public static void show1(List list){
        //添加元素
        list.add( "abc1" );
        list.add( "abc2" );
        list.add( "abc3" );

        System.out.println(list);

        //插入元素
        list.add(1, "abc2" );

        //删除元素
        System.out.println( "remove:" + list.remove(2));

        //修改元素
        System.out.println( "set:" + list.set(1,"abc8" ));

        //获取元素：
        System.out.println( "get:" + list.get(0));

        //获取子列表
        System.out.println( "sublist:" + list.subList(1,2));

        System.out.println(list);
    }


    public static void show2(List list){
        list.add( "abc1");
        list.add( "abc2");
        list.add( "abc3");
        list.add( "abc4");

        Iterator it = list.iterator();
        while(it.hasNext()){
            System.out.println( "next:" + it.next());
        }

        //list特有的取出元素的方式之一
        for(int x = 0; x < list.size(); x++){
            System.out.println( "get:" + list.get(x));
        }
    }
}
