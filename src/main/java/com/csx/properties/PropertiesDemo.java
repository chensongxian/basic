package com.csx.properties;

import org.junit.Test;

import java.io.*;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: Properties练习
 * @Author: csx
 * @Date: 2018-03-10
 */
public class PropertiesDemo {
    @Test
    public void test1(){
        try {
            Properties properties=new Properties();
            InputStream in=new FileInputStream("F:\\idea\\basic\\src\\main\\java\\com\\csx\\properties\\config.properties");
            properties.load(new InputStreamReader(in,"UTF-8"));
            in.close();
            System.out.println(properties.getProperty("name"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }


    @Test
    public void test2(){


        try {
            // 准备配置信息
            Properties properties = new Properties();
            properties.setProperty("name", "李四");
            properties.setProperty("age", "20");

            OutputStream out=new FileOutputStream("F:\\idea\\basic\\src\\main\\java\\com\\csx\\properties\\config.properties");

            properties.store(new OutputStreamWriter(out,"UTF-8"),"这是配置文件");

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
