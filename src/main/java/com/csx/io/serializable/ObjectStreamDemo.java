package com.csx.io.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-03-10
 */
public class ObjectStreamDemo {
    public static void main(String[] args) throws Exception {
        writeObj();
        readObj();
    }

    public static void readObj() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.object" ));

        Person p = (Person)ois.readObject();

        System.out.println(p.getName() + ":" + p.getAge());

        ois.close();
    }


    public static void writeObj() throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.object"));

        Person p = new Person("csx",18);

        oos.writeObject(p);

        oos.flush();
        oos.close();
    }
}
