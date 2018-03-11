package com.csx.io.bytes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-03-10
 */
public class ByteStreamDemo {
    public static void main(String[] args) throws IOException {
        demo_write();

        demo_read1();
        System.out.println( "---------------");
        demo_read2();
        System.out.println( "---------------");
        demo_read3();
    }

    public static void demo_write() throws IOException {
        //1、创建字节输出流对象，用于操作文件
        FileOutputStream fos = new FileOutputStream( "F:\\idea\\basic\\src\\main\\java\\com\\csx\\io\\bytedemo.txt");

        //2、写数据，直接写入到了目的地中
        fos.write( "abcdefg".getBytes());

        //关闭资源动作要完成
        fos.close();
    }

    //读取方式一
    public static void demo_read1() throws IOException {
        //1、创建一个读取流对象，和指定文件关联
        FileInputStream fis = new FileInputStream("F:\\idea\\basic\\src\\main\\java\\com\\csx\\io\\bytedemo.txt" );

        //打印字符字节大小，不过要少用，文件太大，可能内存溢出
        byte[] buf = new byte[fis.available()];
        fis.read(buf);
        System.out.println( new String(buf));

        fis.close();
    }

    //读取方式二
    public static void demo_read2() throws IOException {

        FileInputStream fis = new FileInputStream("F:\\idea\\basic\\src\\main\\java\\com\\csx\\io\\bytedemo.txt" );

        //建议使用这种读取数据的方式
        byte[] buf = new byte[1024];

        int len = 0;

        while((len = fis.read(buf)) != -1){
            System.out.println( new String(buf,0,len));
        }

        fis.close();
    }

    //读取方式三
    public static void demo_read3() throws IOException {

        FileInputStream fis = new FileInputStream("F:\\idea\\basic\\src\\main\\java\\com\\csx\\io\\bytedemo.txt" );

        //一次读取一个字节
        int ch = 0;
        while((ch = fis.read()) != -1){
            System.out.print(( char)ch);
        }

        fis.close();
    }
}
