package com.csx.polymorphic;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-03-09
 */
public class TestPloymorphic {
    public static void main(String args[]){
        A a1 = new A();   A a2 = new B();
        B b = new B();    C c = new C();   D d = new D();
        System.out.println(a1.show(b)); //  ①  A and A
        System.out.println(a1.show(c)); //  ②  A and A
        System.out.println(a1.show(d)); //  ③  A and D
        System.out.println(a2.show(b)); //  ④  B and A
        System.out.println(a2.show(c)); //  ⑤  B and A
        System.out.println(a2.show(d)); //  ⑥  A and D
        System.out.println(b.show(b));  //  ⑦  B and B
        System.out.println(b.show(c));  //  ⑧  B and B
        System.out.println(b.show(d));  //  ⑨  A and D
    }
}
class A {
    public String show(D obj){
        return ("A and D");
    }
    public String show(A obj){
        return ("A and A");
    }
}

class B extends A{
    public String show(B obj){
        return ("B and B");
    }
    public String show(A obj){
        return ("B and A");
    }
}

class C extends B{}
class D extends B{}
