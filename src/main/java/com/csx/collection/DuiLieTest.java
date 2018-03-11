package com.csx.collection;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-03-11
 */
public class DuiLieTest{
    /**
     * LinkedList继承了Deque接口并实现了其方法，所以可以用LinkedList实现队列或栈
     * @param args
     */
    public static void main(String[] args){
        DuiLie dl = new DuiLie();

        dl.myAdd( "abc1");
        dl.myAdd( "abc2");
        dl.myAdd( "abc3");
        dl.myAdd( "abc4");

        while(!dl.isNull()){
            System.out.println(dl.myGet());
        }
    }
}
class DuiLie {
    private LinkedList link;

    public DuiLie(){
        link = new LinkedList();
    }

    //队列的添加元素的功能。
    public void myAdd(Object obj){
        link.addLast(obj);
    }

    public Object myGet(){
        return link.removeFirst();
    }

    public boolean isNull(){
        return link.isEmpty();
    }
}
