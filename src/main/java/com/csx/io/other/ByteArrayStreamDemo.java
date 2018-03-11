package com.csx.io.other;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-03-10
 */
public class ByteArrayStreamDemo {
    public static void main(String[] args) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream("abcdef" .getBytes());
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        int ch = 0;

        while((ch = bis.read()) != -1){
            bos.write(ch);
        }

        System.out.println(bos.toString());
    }
}
