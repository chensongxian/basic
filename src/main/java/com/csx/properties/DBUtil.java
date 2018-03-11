package com.csx.properties;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: Properties工具类
 * @Author: csx
 * @Date: 2018-03-10
 */
public class DBUtil {
    static Properties properties=new Properties();

    static {

        try {
            Class clazz=DBUtil.class;
            InputStreamReader fileReader=new InputStreamReader(clazz.getResourceAsStream("F:\\idea\\basic\\src\\main\\java\\com\\csx\\properties\\config.properties"),"UTF-8");
            properties.load(fileReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getUserName(){
        String userName =properties.getProperty("userName");
        return userName;
    }

    public static String getPassword(){
        return	properties.getProperty("password");
    }
    public static void main(String[] args) {
        System.out.println("用户名："+ getUserName());
        System.out.println("密码: "+  getPassword());
    }

}
