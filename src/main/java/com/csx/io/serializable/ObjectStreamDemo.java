package com.csx.io.serializable;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-03-10
 */
public class ObjectStreamDemo {
    public static void main(String[] args) throws Exception {
        readObj();
    }

    public static void readObj() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.object" ));

        Person p = (Person)ois.readObject();

        System.out.println(p.getName() + ":" + p.getAge());

        ois.close();
    }
}
