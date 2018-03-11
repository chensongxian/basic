package com.csx.collection;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-03-11
 */
public class ArrayListTest {
    public static void main(String[] args){
        ArrayList al = new ArrayList();
        al.add( new Person1("lisi1" ,21));
        al.add( new Person1("lisi2" ,22));
        al.add( new Person1("lisi3" ,23));
        al.add( new Person1("lisi4" ,24));
        al.add( new Person1("lisi3" ,23));
        al.add( new Person1("lisi4" ,24));

        System.out.println(al);

        al = getSingleElement(al);

        //remove底层用的还是equals方法
        System.out.println(al.remove( new Person1("lisi2" ,22)));
        System.out.println(al);
    }

    public static ArrayList getSingleElement(ArrayList al){
        //1、定义一个临时容器
        ArrayList temp = new ArrayList();

        //2、迭代al集合
        Iterator it = al.iterator();

        while(it.hasNext()){
            Object obj = it.next();

            //3、判断被迭代到的元素是否在临时容器存在
            //contains方法依靠的是equals方法
            if(!temp.contains(obj)){
                temp.add(obj);
            }
        }
        return temp;
    }
}
