package com.csx.io.bytes;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-03-10
 */
public class TransStreamDemo {
    public static void main(String[] args) throws IOException {
        //字节流
        InputStream in = System.in;

        //将字节转成字符的桥梁，转换流
        InputStreamReader isr = new InputStreamReader(in);

        //对字符流进行高效装饰，缓冲区
        BufferedReader bufr = new BufferedReader(isr);

        String line = null;

        //读取到了字符串数据
        while((line = bufr.readLine()) != null){
            if("over" .equals(line))
                break;
            System.out.println(line.toUpperCase());
        }
    }

    public void test1() throws IOException {
        InputStream in = System.in;

        InputStreamReader isr = new InputStreamReader(in);

        //字符流
        BufferedReader bufr = new BufferedReader(isr);

        //字节流，字节数据
        OutputStream out = System.out;

        //数据到了osw，目的地out控制台
        OutputStreamWriter osw = new OutputStreamWriter(out);

        BufferedWriter bufw = new BufferedWriter(osw);

        String line = null;

        while((line = bufr.readLine()) != null){
            if("over" .equals(line))
                break;

            //将字符数据用缓冲区对象将数据写入缓冲区，目的地是osw
            bufw.write(line.toUpperCase());
            bufw.newLine();
            //osw.write(line.toUpperCase() + "\r\n");可以替代上面两行代码
            bufw.flush();
        }
    }

    public void test2() throws IOException {
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = null;

        while((line = bufr.readLine()) != null){
            if("over" .equals(line))
                break;

            bufw.write(line.toUpperCase());
            bufw.newLine();
            bufw.flush();
        }
    }

    public void test3() throws IOException {
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("a.txt")));

        String line = null;

        while((line = bufr.readLine()) != null){
            if("over" .equals(line))
                break;

            bufw.write(line.toUpperCase());
            bufw.newLine();
            bufw.flush();
        }
    }

    public void test4() throws IOException {
        BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream("a.txt")));

        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = null;

        while((line = bufr.readLine()) != null){
            if("over" .equals(line))
                break;

            bufw.write(line.toUpperCase());
            bufw.newLine();
            bufw.flush();
        }
    }

    public void test5() throws IOException {
        BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream("a.txt")));

        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("b.txt")));

        String line = null;

        while((line = bufr.readLine()) != null){
            if("over" .equals(line))
                break;

            bufw.write(line.toUpperCase());
            bufw.newLine();
            bufw.flush();
        }
    }
}
