package com.csx.io.buffer;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-03-10
 */
public class BufferedWriterDemo {
    @Test
    public void test1() throws IOException {
        FileWriter fw = new FileWriter("F:\\idea\\basic\\src\\main\\java\\com\\csx\\io\\buf.txt" );

        //为了提高写入的效率，使用了字符流的缓冲区
        //创建了一个字符写入流的缓冲区对象，并且指定与要被缓冲的流对象相关联
        BufferedWriter bufw = new BufferedWriter(fw);

        for(int x = 1; x <= 4; x++){
            //使用缓冲区的写入方法将数据先写入到缓冲区中
            bufw.write( "abcdef" + x);
            //写入内容换行方法：newLine();
            bufw.newLine();
            bufw.flush();
        }

        //使用缓冲区的刷新方法将数据刷目的地中
        bufw.flush();

        //关闭缓冲区，其实关闭的就是被缓冲的流对象
        fw.close();
    }
}
