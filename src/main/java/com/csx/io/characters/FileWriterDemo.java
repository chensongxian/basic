package com.csx.io.characters;

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-03-10
 */
public class FileWriterDemo {
    @Test
   public void test1() throws IOException {
        /*
         *  创建一个可以往文件中写入字符数据的字符输出流对象
         *
         *  既然是往一个文件中写入文字数据，那么在创建对象时，就必须明确该文件（用于存储数据的目的地）
         *
         *  如果文件不存在，则会自动创建
         *
         *  如果文件存在，则会被覆盖
         *
         */
        FileWriter fw=new FileWriter("F:\\idea\\basic\\src\\main\\java\\com\\csx\\io\\demo.txt");

        /*
         *  调用Writer对象中的write(string)方法，写入数据
         *  其实数据写入到临时存储缓冲区中
         */
        fw.write( "abcde");

        //进行刷新，将数据直接写入到目的地中
        fw.flush();

        //关闭流，关闭资源，在关闭前会先调用flush刷新缓冲中的数据到目的地。
        fw.close();

    }


    @Test
    public void test2() throws IOException {

        /*
         * 构造函数添加true，续写文件
         */
        FileWriter fw=new FileWriter("F:\\idea\\basic\\src\\main\\java\\com\\csx\\io\\demo.txt",true);


        fw.write( "xixi");

        fw.close();

    }

    /**
     *  IO流的异常处理方式：为防止代码异常导致流无法关闭，因此在finally中对流进行关闭
     */
    @Test
    public void test3(){
        FileWriter fw= null;
        try {
            fw = new FileWriter("F:\\idea\\basic\\src\\main\\java\\com\\csx\\io\\demo.txt");
            fw.write( "xixi");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }finally {
            if(fw!=null){
                try {
                    fw.close();
                } catch (IOException e) {
                    throw new RuntimeException("关闭流失败");
                }
            }
        }
    }
}


