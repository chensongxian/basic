package com.csx.io.buffer;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-03-10
 */
public class PersonDemo {
    /**
     * 装饰和继承都可以进行功能的扩展增强，但是装饰比继承灵活
     *
     * 装饰类和被装饰类都必须所属同一个接口或者父类
     * @param args
     */
    public static void main(String[] args){
        Person p = new Person();
        NewPerson np1 = new NewPerson(p);
        np1.chifan();

        System.out.println( "---------------");

        NewPerson2 np2 = new NewPerson2();
        np2.chifan();
    }
}

class Person{
    void chifan(){
        System.out.println( "吃饭");
    }
}

//采用装饰的方式增强Person类
//这个类的出现是为了增强Person而出现的
class NewPerson{
    private Person p;

    NewPerson(Person p){
        this.p = p;
    }

    public void chifan(){
        System.out.println( "开胃酒");
        p.chifan();
        System.out.println( "甜点");
    }
}

//采用继承的方式增强Person类
class NewPerson2 extends Person{
    public void chifan(){
        System.out.println( "开胃酒");
        super.chifan();
        System.out.println( "甜点");
    }
}