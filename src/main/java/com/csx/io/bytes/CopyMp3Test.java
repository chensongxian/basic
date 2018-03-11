package com.csx.io.bytes;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-03-10
 */
public class CopyMp3Test {
    public static void main(String[] args) throws IOException {
        copy_1();
        copy_2();
    }

    public static void copy_1() throws IOException {
        FileInputStream fis = new FileInputStream("0.mp3" );
        FileOutputStream fos = new FileOutputStream("1.mp3" );

        byte[] buf = new byte[1024];

        int len = 0;

        while((len = fis.read(buf)) != -1){
            fos.write(buf,0,len);
        }

        fis.close();
        fos.close();
    }

    public static void copy_2() throws IOException {
        FileInputStream fis = new FileInputStream("0.mp3" );
        BufferedInputStream bufis = new BufferedInputStream(fis);

        FileOutputStream fos = new FileOutputStream("2.mp3" );
        BufferedOutputStream bufos = new BufferedOutputStream(fos);

        int ch = 0;

        while((ch = bufis.read()) != -1){
            bufos.write(ch);
        }

        bufis.close();
        bufos.close();
    }
}
