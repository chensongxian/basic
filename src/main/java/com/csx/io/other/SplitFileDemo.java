package com.csx.io.other;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-03-10
 */
public class SplitFileDemo {
    private static final int SIZE = 1024*1024;

    public static void main(String[] args) throws IOException {
        File file = new File("0.mp3" );
        splitFile(file);
    }

    public static void splitFile(File file) throws IOException {
        //用读取流关联源文件
        FileInputStream fis = new FileInputStream(file);

        //定义一个1M的缓冲区
        byte[] buf = new byte[SIZE];

        //创建目的
        FileOutputStream fos = null;

        int len = 0;
        int count = 1;

        //切割文件时，必须记录住被切割文件的名称，以及切割出来碎片文件的个数，以方便于合并。
        //这个信息为了进行描述，使用键值对的方式，用到了properties对象。

        Properties prop = new Properties();

        File dir = new File("c:\\partFiles" );
        if(!dir.exists())
            dir.mkdirs();

        while((len = fis.read(buf)) != -1){
            fos = new FileOutputStream(new File(dir,(count++) + ".part"));
            fos.write(buf,0,len);
            fos.close();
        }

        //将被切割文件的信息保存到prop集合中
        prop.setProperty( "partcount",count + "" );
        prop.setProperty( "filename",file.getName());

        fos = new FileOutputStream(new File(dir,count + ".properties" ));

        //将prop集合中的数据存储到文件中
        prop.store(fos, "save file info");

        fis.close();
        fos.close();
    }
}
