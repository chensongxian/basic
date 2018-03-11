package com.csx.io.other;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-03-10
 */
public class SequenceInputStreamDemo {
    public static void main(String[] args) throws IOException {
        Vector<FileInputStream> v = new Vector<FileInputStream>();

        v.add( new FileInputStream("1.txt" ));
        v.add( new FileInputStream("2.txt" ));
        v.add( new FileInputStream("3.txt" ));

        Enumeration<FileInputStream> en = v.elements();

        SequenceInputStream sis = new SequenceInputStream(en);

        FileOutputStream fos = new FileOutputStream("4.txt" );

        byte[] buf = new byte[1024];

        int len = 0;

        while((len = sis.read(buf)) != -1){
            fos.write(buf,0,len);
        }

        fos.close();
        sis.close();
    }
}
