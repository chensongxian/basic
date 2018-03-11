package com.csx.io.characters;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-03-10
 */
public class FileReaderDemo {
    /**
     * 使用read()方法读取文本文件数据
     * 一个个字节读取
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        FileReader fr = new FileReader("F:\\idea\\basic\\src\\main\\java\\com\\csx\\io\\demo.txt" );

        //用Reader中的read方法读取字符
        int ch = 0;

        while((ch = fr.read()) != -1){
            System.out.println(( char)ch);
        }

        fr.close();
    }

    /**
     * 使用read(characters[])方法读取文本文件数据
     *
     * 用数组读取
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        FileReader fr = new FileReader("F:\\idea\\basic\\src\\main\\java\\com\\csx\\io\\demo.txt" );

        //使用read(characters[])读取文本文件数据
        //先创建字符数组
        char[] buf = new char[3];

        int len = 0;

        while((len = fr.read(buf)) != -1){
            System.out.println( new String(buf,0,len));
        }

        fr.close();
    }
}
