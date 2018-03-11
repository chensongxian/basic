package com.csx.collection;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-03-11
 */
public class HashSetTest {
    /**
     * HasSet不可以重复，而其判断是否相等需要对象的hashcode和equals方法
     *
     *   哈希表确定元素是否相同
     *  1. 判断的是两个元素的哈希值是否相同。
     *  如果相同，再判断两个对象的内容是否相同。
     *  2. 判断哈希值相同，其实判断的是对象的HashCode方法。判断内容相同，用的是equals方法
     * @param args
     */
    public static void main(String[] args) {
        HashSet hs = new HashSet();

        hs.add( new Person1("lisi4" ,24));
        hs.add( new Person1("lisi7" ,27));
        hs.add( new Person1("lisi1" ,21));
        hs.add( new Person1("lisi9" ,29));
        hs.add( new Person1("lisi7" ,27));

        Iterator it = hs.iterator();

        while(it.hasNext()){
            Person1 p = (Person1)it.next();
            System.out.println(p.getName() + "..." + p.getAge());
        }
    }
}

class Person{
    private String name;
    private int age;

    public Person(){
    }

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this .name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return this .age;
    }

    public int hashCode(){
        return name.hashCode() + age * 39;
    }

    public boolean equals(Object obj){
        if(this == obj)
            return true ;//同一个对象放两次，直接返回true

        if(!(obj instanceof Person1))
            throw new ClassCastException("类型错误");

        Person p = (Person)obj;

        return this .name.equals(p.name) && this.age == p.age;
    }
}