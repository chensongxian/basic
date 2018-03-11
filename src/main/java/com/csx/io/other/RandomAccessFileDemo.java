package com.csx.io.other;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-03-10
 */
public class RandomAccessFileDemo {
    public static void main(String[] args) throws IOException {
        writeFile();
    }

    //使用RandomAccessFile对象写入一些人员信息，比如姓名和年龄
    public static void writeFile() throws IOException {
        //如果文件不存在，则创建，如果文件存在，不创建
        RandomAccessFile raf = new RandomAccessFile("ranacc.txt" ,"rw" );

        raf.write( "张三".getBytes());
        //使用write方法之写入最后一个字节
        raf.write(97);
        //使用writeInt方法写入四个字节（int类型）
        raf.writeInt(97);

        raf.write( "小强".getBytes());
        raf.writeInt(99);

        raf.close();
    }


    public static void readFile() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("ranacc.txt" ,"r" );

        //通过seek设置指针的位置
        raf.seek(9); //随机的读取，只要指定指针的位置即可

        byte[] buf = new byte[4];
        raf.read(buf);

        String name = new String(buf);
        System.out.println( "name=" + name);

        int age = raf.readInt();
        System.out.println( "age=" + age);

        System.out.println( "pos:" + raf.getFilePointer());

        raf.close();
    }


    public static void randomWrite() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("ranacc.txt" ,"rw" );

        //往指定位置写入数据
        raf.seek(3*8);

        raf.write( "哈哈".getBytes());
        raf.writeInt(102);

        raf.close();
    }
}
