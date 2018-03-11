package com.csx.collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-03-11
 */
public class TreeMapDemo {
    public static void main(String[] args){
        //将学生对象和学生的归属地通过键与值存储到map集合中
        TreeMap<Student,String> tm = new TreeMap<Student,String>(new ComparatorByName1());

        tm.put( new Student("lisi" ,38),"北京");
        tm.put( new Student("zhaoliu" ,24),"上海");
        tm.put( new Student("xiaoqiang" ,31),"沈阳");
        tm.put( new Student("wangcai" ,28),"大连");
        tm.put( new Student("zhaoliu" ,24),"铁岭");

        Iterator<Map.Entry<Student,String>> it = tm.entrySet().iterator();

        while(it.hasNext()){
            Map.Entry<Student,String> me = it.next();
            Student key = me.getKey();
            String value = me.getValue();
            System.out.println(key.getName() + ":" + key.getAge() + "---" + value);
        }
    }
}

class ComparatorByName1 implements Comparator<Student> {
    public int compare(Student s1,Student s2){
        int temp = s1.getName().compareTo(s2.getName());
        return temp == 0?s1.getAge() - s2.getAge():temp;
    }
}