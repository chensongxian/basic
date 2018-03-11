package com.csx.io.buffer;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-03-10
 */
public class MyBufferedReaderDemo {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("buf.txt" );

        MyBufferedReader bufr = new MyBufferedReader(fr);

        String line = null ;

        while ((line = bufr.myReadLine()) != null){
            System.out.println(line);
        }

        bufr.myClose();
    }
}

class MyBufferedReader{

    private Reader r;

    //定义一个数组作为缓冲区
    private char[] buf = new char[1024];

    //定义一个指针用于操作这个数组中的元素，当操作到最后一个元素后，指针应该归零
    private int pos = 0;

    //定义一个计数器用于记录缓冲区中的数据个数，当该数据减到0，就从源中继续获取数据到缓冲区中
    private int count = 0;

    MyBufferedReader(Reader r){
        this .r = r;
    }

    //该方法从缓冲区中一次取一个字符
    public int myRead() throws IOException {
        //从源中获取一批数据到缓冲区中，需要先做判断，只有计数器为0时，才需要从源中获取数据
        if (count == 0){
            count = r.read(buf);

            //每次获取数据到缓冲区后，角标归零
            pos = 0;
        }

        if (count < 0)
            return -1;

        char ch = buf[pos];

        pos++;
        count--;

        return ch;
    }

    public String myReadLine() throws IOException {
        StringBuilder sb = new StringBuilder();

        int ch = 0;
        while ((ch = myRead()) != -1){
            if (ch == '\r' )
                continue ;
            if (ch == '\n' )
                return sb.toString();
            //将从缓冲区读到的字符，存储到缓存行数据的缓冲区中
            sb.append(( char )ch);
        }

        if (sb.length() != 0){
            return sb.toString();
        }
        return null ;
    }

    public void myClose() throws IOException {
        r.close();
    }
}
