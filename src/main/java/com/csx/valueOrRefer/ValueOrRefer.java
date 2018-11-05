package com.csx.valueOrRefer;

/**
 * @author csx
 * @Package com.csx.valueOrRefer
 * @Description: 验证java中引用对象的传递，是值传递还是引用传递
 * @date 2018/11/5 0005
 */
public class ValueOrRefer {

    /**
     * 输出结果：
     * Person{name='1', age=18}
     * Person{name='2', age=19}
     *
     * 由上述结果表明，调用swap方法之后person对象a和b并没有发生交换
     * 还是保留原来的值不变,究其原因是调用swap中传入的值并非person对象
     * 的引用地址，而是其拷贝值。因此得出结论java中所谓的“引用传递”并非
     * 引用传递，归根到底还是值传递，只是其值变成了引用类型的地址拷贝值
     *
     * @param args
     */
    public static void main(String[] args) {
        Person a = new Person("1",18);
        Person b = new Person("2",19);

        swap(a, b);

        System.out.println(a);
        System.out.println(b);
    }

    public static void swap(Person a, Person b) {
        Person tmp = a;
        a = b;
        b = tmp;
    }
}
