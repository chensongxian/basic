package com.csx.io.characters;

import org.junit.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-03-10
 */
public class CopyTextTest {
    private static final int BUFFER_SIZE = 1024;

    @Test
    public void test1() throws IOException {
        //1、读取一个已有的文本文件，使用字符读取流和文件相关联
        FileReader fr = new FileReader("F:\\idea\\basic\\src\\main\\java\\com\\csx\\io\\demo.txt" );

        //2、创建一个目的，用于存储读到数据。
        FileWriter fw = new FileWriter("F:\\idea\\basic\\src\\main\\java\\com\\csx\\io\\copyText_1.txt" );

        //3、频繁的读写操作
        int ch = 0;
        while((ch = fr.read()) != -1){
            fw.write(ch);
        }

        //4、关闭字节流
        fw.close();
        fr.close();
    }

    @Test
    public void test2(){
        FileReader fr = null;
        FileWriter fw = null;

        try{
            fr = new FileReader("F:\\idea\\basic\\src\\main\\java\\com\\csx\\io\\demo.txt" );
            fw = new FileWriter("F:\\idea\\basic\\src\\main\\java\\com\\csx\\io\\copyText_1.txt" );

            //创建一个临时容器，用于缓存读取到的字符
            char[] buf = new char[BUFFER_SIZE];

            //定义一个变量记录读取到的字符数（其实就是往数组里装的字符个数）
            int len = 0;

            while((len = fr.read(buf)) != -1){
                fw.write(buf,0,len);
            }
        } catch(Exception e){
            throw new RuntimeException("读写失败!");
        } finally{
            if(fw != null){
                try{
                    fw.close();
                } catch(IOException e){
                    System.out.println(e.toString());
                }
            }
            if(fr != null){
                try{
                    fw.close();
                } catch(IOException e){
                    System.out.println(e.toString());
                }
            }
        }
    }
}
