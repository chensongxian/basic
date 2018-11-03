package com.csx.io.bytes;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-03-10
 */
public class ReadKey {
    public static void main(String[] args) throws IOException {
//        readKey();
        readKey_1();
    }

    public static void readKey() throws IOException {
        InputStream in = System.in;
        int ch = in.read();//阻塞式方法
        System.out.println(ch);

        ch = in.read(); //阻塞式方法
        System.out.println(ch);

        ch = in.read(); //阻塞式方法
        System.out.println(ch);

        in.close();
    }


    public static void readKey_1() throws IOException {

        //1、创建容器
        StringBuilder sb = new StringBuilder();

        //2、获取键盘读取流
        InputStream in = System.in;

        //3、定义变量记录读取到的字节，并循环获取
        int ch = 0;

        while((ch = in.read()) != -1){
            //在存储之前需要判断是否是换行标记，因为换行标记不存储
            if(ch == '\r' )
                continue;
            if(ch == '\n' ){
                String temp = sb.toString();
                if("over" .equals(temp))
                    break;
                System.out.println(temp.toUpperCase());
                sb.delete(0,sb.length());
            } else{
                //将读取到的字节存储到StringBuilder中
                sb.append(( char)ch);
            }
        }
    }
}
