package com.csx.collection;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-03-11
 */
public class HashMapDemo {
    public static void main(String[] args){
        //将学生对象和学生的归属地通过键与值存储到map集合中
        HashMap<Student,String> hm = new HashMap<Student,String>();

        hm.put( new Student("lisi" ,38),"北京");
        hm.put( new Student("zhaoliu" ,24),"上海");
        hm.put( new Student("xiaoqiang" ,31),"沈阳");
        hm.put( new Student("wangcai" ,28),"大连");
        hm.put( new Student("zhaoliu" ,24),"铁岭");

        Iterator<Student> it = hm.keySet().iterator();

        while(it.hasNext()){
            Student key = it.next();
            String value = hm.get(key);
            System.out.println(key.getName() + ":" + key.getAge() + "---" + value);
        }
    }
}


class Student {
    private String name;
    private int age;

    public Student(){
    }

    public Student(String name,int age){
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

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true ;
        if (obj == null)
            return false ;
        if (getClass() != obj.getClass())
            return false ;
        Student other = (Student) obj;
        if (age != other.age)
            return false ;
        if (name == null) {
            if (other.name != null)
                return false ;
        } else if (!name.equals(other.name))
            return false ;
        return true ;
    }
}