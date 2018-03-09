package com.csx.string;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: String字符串深入解析
 * @Author: csx
 * @Date: 2018/03/09
 */
public class StringDemo {
    /**
     * 第一种先在栈中创建一个对String类的对象引用变量s，然后去查找"abc"是否被保存在字符串常量池中，
     * 如果没有则在栈中创建三个char型的值'a'、'b'、'c'，然后在堆中创建一个String对象object，
     * 它的值是刚才在栈中创建的三个char型值组成的数组{'a'、'b'、'c'}，
     * 接着这个String对象object被存放进字符串常量池，最后将s指向这个对象的地址。
     *
     * 如果"abc"已经被保存在字符串常量池中，则在字符串常量池中找到值为"abc"的对象object，然后将s指向这个对象的地址
     *
     * 特点:JVM会自动根据栈中数据的实际情况来决定是否有必要创建新对象。
     *
     * 下面的例子中,s和s1便是引用了同一个对象
     */
    @Test
    public void test1(){
        String s="abc";
        String s1="abc";
        //s==s1,结果为true
        System.out.println(s==s1);
    }

    /**
     *  String s1=new String("abc");的创建过程如下
     *  第二种可以分解成两步
     *      String object = "abc";
     *      String s = new String(object);
     *  第一步参考第一种创建方式，
     *  而第二步由于"abc"已经被创建并保存到字符串常量池中，因此jvm只会在堆中新创建一个String对象，它的值共享栈中已有的三个char型值。
     *
     *  特点:一概在堆中创建新对象，而不管其字符串值是否相等，是否有必要创建新对象。
     */
    @Test
    public void test2(){
        String s="abc";
        String s1=new String("abc");
        //s==s1,结果为false
        System.out.println(s==s1);
    }


    @Test
    public void test3(){
        String s0 =new String ("abc");
        String s1 =new String ("abc");
        /*
         * 不同对象所以结果为false
         */
        System.out.println(s0==s1);
        /*
         * s0和s1内容相同所以为true
         */
        System.out.println(s0.equals(s1));
    }

    /**
     * 编译器确定
     *
     * 分析：因为例子中的s0和s1中的"helloworld”都是字符串常量，它们在编译期就被确定了，所以s0 == s1为true；
     * 而"hello”和"world”也都是字符串常量，当一个字符串由多个字符串常量连接而成时，它自己肯定也是字符串常量，
     * 所以s2也同样在编译期就被解析为一个字符串常量，所以s2也是常量池中"helloworld”的一个引用。
     * 所以我们得出s0 == s1 == s2；
     */
    @Test
    public void test4(){
        String s0="helloworld";
        String s1="helloworld";
        String s2="hello" + "world";
        //true
        System.out.println( s0==s1 );
        //true
        System.out.println( s0==s2 );
    }

    /**
     *  分析:用new String() 创建的字符串不是常量，不能在编译期就确定，所以new String() 创建的字符串不放入常量池中，它们有自己的地址空间。
     *  s0还是常量池中"helloworld”的引用，s1因为无法在编译期确定，所以是运行时创建的新对象"helloworld”的引用，
     *  s2因为有后半部分new String(”world”)所以也无法在编译期确定，所以也是一个新创建对象"helloworld”的引用；
     */
    @Test
    public void test5(){
        String s0="helloworld";
        String s1=new String("helloworld");
        String s2="hello" + new String("world");
        //false
        System.out.println( s0==s1 );
        //false
        System.out.println( s0==s2 );
        //false
        System.out.println( s1==s2 );
    }

    /**
     * 分析：在程序编译期，JVM就将常量字符串的"+"连接优化为连接后的值，
     * 拿"a" + 1来说，经编译器优化后在class中就已经是a1。
     * 在编译期其字符串常量的值就确定下来，故上面程序最终的结果都为true。
     */
    @Test
    public void test6(){
        String s0 = "a1";
        String s1 = "a" + 1;
        //true
        System.out.println((s0 == s1));
        String s2 = "atrue";
        String s3= "a" + "true";
        //true
        System.out.println((s2 == s3));
        String s4 = "a3.4";
        String s5 = "a" + 3.4;
        //true
        System.out.println((s4 == s5));
    }

    /**
     * 分析：JVM对于字符串引用，由于在字符串的"+"连接中，有字符串引用存在，而引用的值在程序编译期是无法确定的，
     * 即"a" + s1无法被编译器优化，只有在程序运行期来动态分配并将连接后的新地址赋给s2。所以上面程序的结果也就为false。
     */
    @Test
    public void test7(){
        String s0 = "ab";
        String s1 = "b";
        String s2 = "a" + s1;
        //false
        System.out.println((s0 == s2));
    }

    /**
     * 分析：和test7中唯一不同的是s1字符串加了final修饰，对于final修饰的变量，
     * 它在编译时被解析为常量值的一个本地拷贝存储到自己的常量 池中或嵌入到它的字节码流中。所以此时的"a" + s1和"a" + "b"效果是一样的。故上面程序的结果为true。
     */
    @Test
    public void test8(){
        String s0 = "ab";
        final String s1 = "b";
        String s2 = "a" + s1;
        //true
        System.out.println((s0 == s2));
    }

    /**
     * 分析：JVM对于字符串引用s1，它的值在编译期无法确定，
     * 只有在程序运行期调用方法后，将方法的返回值和"a"来动态连接并分配地址为s2，故上面 程序的结果为false。
     */
    @Test
    public void test9(){
        String s0 = "ab";
        final String s1 = getS1();
        String s2 = "a" + s1;
        System.out.println((s0 == s2));
    }

    private String getS1() {
        return "b";
    }
}
