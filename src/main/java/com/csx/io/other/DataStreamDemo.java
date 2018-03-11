package com.csx.io.other;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-03-10
 */
public class DataStreamDemo {
    public static void main(String[] args) throws IOException {
        writeData();
    }

    public static void writeData() throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt" ));

        dos.writeUTF( "您好");

        dos.close();
    }

    public static void readData() throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream("data.txt" ));

        String str = dis.readUTF();

        System.out.println(str);

        dis.close();
    }
}
