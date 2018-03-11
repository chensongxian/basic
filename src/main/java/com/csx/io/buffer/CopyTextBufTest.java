package com.csx.io.buffer;

import org.junit.Test;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-03-10
 */
public class CopyTextBufTest {
    @Test
    public void test1() throws IOException {
        FileReader fr = new FileReader("F:\\idea\\basic\\src\\main\\java\\com\\csx\\io\\buf.txt" );
        BufferedReader bufr = new BufferedReader(fr);

        FileWriter fw = new FileWriter("F:\\idea\\basic\\src\\main\\java\\com\\csx\\io\\buf_copy.txt" );
        BufferedWriter bufw = new BufferedWriter(fw);

        String line = null;

        //方式一
        while((line = bufr.readLine()) != null){
            bufw.write(line);
            bufw.newLine();
            bufw.flush();
        }

        //方式二
             /*
            int ch = 0;

            while((ch = bufr.read()) != -1){
                  bufw.write(ch);
            }
            */

        bufr.close();
        bufw.close();
    }
}
