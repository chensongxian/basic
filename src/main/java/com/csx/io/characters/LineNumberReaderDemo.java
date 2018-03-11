package com.csx.io.characters;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-03-10
 */
public class LineNumberReaderDemo {
    /**
     *  跟踪行号的缓冲字符输入流。此类定义了方法 setLineNumber(int) 和 getLineNumber()，它们可分别用于设置和获取当前行号
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        FileReader fr = new FileReader("F:\\idea\\basic\\src\\main\\java\\com\\csx\\io\\LineNumberReaderDemo.java" );
        LineNumberReader lnr = new LineNumberReader(fr);

        String line = null;

        lnr.setLineNumber(100);

        while((line = lnr.readLine()) != null){
            System.out.println(lnr.getLineNumber() + ":" + line);
        }

        lnr.close();
    }
}
