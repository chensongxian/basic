package com.csx.io.buffer;

import org.junit.Test;

import java.io.BufferedReader;
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
public class BufferedReaderDemo {
    /**
     * 使用了读取缓冲区的read方法，将读取到的字符进行缓冲并判断换行标记，将标记前的缓冲数据变成字符串返回
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        FileReader fr = new FileReader("F:\\idea\\basic\\src\\main\\java\\com\\csx\\io\\buf.txt" );

        BufferedReader bufr = new BufferedReader(fr);

        String line = null;

        while((line = bufr.readLine()) != null){
            System.out.println(line);
        }

        bufr.close();
    }
}
