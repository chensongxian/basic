package com.csx.objectcopy;

import org.junit.Test;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/03/09
 */
public class CopyTest {
    /**
     * 浅拷贝测试
     * @throws CloneNotSupportedException
     */
    @Test
    public void testShallowCopy() throws CloneNotSupportedException {
        // 原始对象
        Student stud = new Student("John", "Algebra");
        System.out.println("Original Object: " + stud.getName() + " - " + stud.getSubj().getName());
        // 拷贝对象
        Student clonedStud = (Student) stud.clone();
        System.out.println("Cloned Object: " + clonedStud.getName() + " - " + clonedStud.getSubj().getName());
        // 原始对象和拷贝对象是否一样：
        System.out.println("Is Original Object the same with Cloned Object: " + (stud == clonedStud));
        // 原始对象和拷贝对象的name属性是否一样
        System.out.println("Is Original Object's field name the same with Cloned Object: " +
                (stud.getName() == clonedStud.getName()));
        // 原始对象和拷贝对象的subj属性是否一样
        System.out.println("Is Original Object's field subj the same with Cloned Object: " +
                (stud.getSubj() == clonedStud.getSubj()));
        stud.setName("Dan");
        stud.getSubj().setName("Physics");
        System.out.println("Original Object after it is updated: " + stud.getName() + " - " +
                stud.getSubj().getName());
        System.out.println("Cloned Object after updating original object: " + clonedStud.getName() +
                " - " + clonedStud.getSubj().getName());
    }


    /**
     * 深拷贝
     * @throws CloneNotSupportedException
     */
    @Test
    public void testDeepCopy() throws CloneNotSupportedException {
        // 原始对象
        Student1 stud = new Student1("John", "Algebra");
        System.out.println("Original Object: " + stud.getName() + " - " + stud.getSubj().getName());
        // 拷贝对象
        Student1 clonedStud = (Student1) stud.clone();
        System.out.println("Cloned Object: " + clonedStud.getName() + " - " + clonedStud.getSubj().getName());
        // 原始对象和拷贝对象是否一样：
        System.out.println("Is Original Object the same with Cloned Object: " + (stud == clonedStud));
        // 原始对象和拷贝对象的name属性是否一样
        System.out.println("Is Original Object's field name the same with Cloned Object: " +
                (stud.getName() == clonedStud.getName()));
        // 原始对象和拷贝对象的subj属性是否一样
        System.out.println("Is Original Object's field subj the same with Cloned Object: " +
                (stud.getSubj() == clonedStud.getSubj()));
        stud.setName("Dan");
        stud.getSubj().setName("Physics");
        System.out.println("Original Object after it is updated: " + stud.getName() + " - " +
                stud.getSubj().getName());
        System.out.println("Cloned Object after updating original object: " + clonedStud.getName() +
                " - " + clonedStud.getSubj().getName());
    }

    /**
     * 序列化实现深拷贝
     */
    @Test
    public void testDeepCopyBySerializable(){
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        try {
            // 创建原始的可序列化对象
            ColoredCircle c1 = new ColoredCircle(100, 100);
            System.out.println("Original = " + c1);

            ColoredCircle c2 = null;

            // 通过序列化实现深拷贝
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            // 序列化以及传递这个对象
            oos.writeObject(c1);
            oos.flush();
            ByteArrayInputStream bin = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bin);
            // 返回新的对象
            c2 = (ColoredCircle) ois.readObject();

            // 校验内容是否相同
            System.out.println("Copied   = " + c2);
            // 改变原始对象的内容
            c1.setX(200);
            c1.setY(200);
            // 查看每一个现在的内容
            System.out.println("Original = " + c1);
            System.out.println("Copied   = " + c2);
        } catch (Exception e) {
            System.out.println("Exception in main = " + e);
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
