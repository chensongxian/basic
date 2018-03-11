package com.csx.io.other;

import java.io.PrintStream;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-03-10
 */
public class PrintStreamDemo {
    public static void main(String[] args) throws Exception {
        PrintStream out = new PrintStream("F:\\idea\\basic\\src\\main\\java\\com\\csx\\io\\print.txt" );

        //write(int b)方法只写最低8位
        out.write(97); //a
        //print方法将97先变成字符串保持原样将数据打印到目的地
        out.print(97); //97

        out.close();
    }
}
