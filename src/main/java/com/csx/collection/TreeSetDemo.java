package com.csx.collection;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-03-11
 */
public class TreeSetDemo {
    /**
     * 通过实现Comparable接口来对treeset排序
     */
    public void testSortByComparable(){
        TreeSet ts = new TreeSet();

        //以Person对象年龄进行从小到大的排序
        ts.add( new Person("zhangsan" ,28));
        ts.add( new Person("wangwu" ,23));
        ts.add( new Person("lisi" ,21));
        ts.add( new Person("zhouqi" ,29));
        ts.add( new Person("zhaoliu" ,25));

        Iterator it = ts.iterator();

        while(it.hasNext()){
            Person p = (Person)it.next();

            System.out.println(p.getName() + ":" + p.getAge());
        }
    }

    /**
     * 通过比较器来实现对TreeSet的排序
     *
     */
    @Test
    public void testSortByCompartor(){
        TreeSet ts = new TreeSet(new ComparatorByName());

        //以Person对象年龄进行从小到大的排序
        ts.add( new Person("zhangsan" ,28));
        ts.add( new Person("wangwu" ,23));
        ts.add( new Person("lisi" ,21));
        ts.add( new Person("zhouqi" ,29));
        ts.add( new Person("zhaoliu" ,25));

        Iterator it = ts.iterator();

        while(it.hasNext()){
            Person p = (Person)it.next();

            System.out.println(p.getName() + ":" + p.getAge());
        }
    }
}

class ComparatorByLen implements Comparator{
    public int compare(Object o1,Object o2){
        String s1 = (String)o1;
        String s2 = (String)o2;

        int temp = s1.length() - s2.length();

        return temp == 0?s1.compareTo(s2):temp;
    }
}

//创建了一个根据Person类的name进行排序的比较器。
class ComparatorByName implements Comparator {
    public int compare(Object o1,Object o2){
        Person1 p1 = (Person1)o1;
        Person1 p2 = (Person1)o2;

        int temp = p1.getName().compareTo(p2.getName());
        return temp == 0?p1.getAge()-p2.getAge() : temp;
    }
}

class Person1 implements Comparable{
    private String name;
    private int age;

    public Person1(){
    }

    public Person1(String name, int age){
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
            return true ;

        if(!(obj instanceof Person1))
            throw new ClassCastException("类型错误");

        Person1 p = (Person1)obj;

        return this .name.equals(p.name) && this.age == p.age;
    }

    public int compareTo(Object o){
        Person1 p = (Person1)o;

        //先按照年龄排序，再按照年龄排序，以免年龄相同的人，没有存进去。
        int temp = this.age - p.age;
        return temp == 0?this.name.compareTo(p.name):temp;
    }
}
