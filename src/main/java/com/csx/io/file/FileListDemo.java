package com.csx.io.file;

import org.junit.Test;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-03-10
 */
public class FileListDemo {
    public static void main(String[] args){
        listDemo();
    }

    public static void listDemo(){
        File dir = new File("c:\\" );

        File[] files = dir.listFiles( new FilterByHidden());

        for(File file : files){
            System.out.println(file);
        }
    }

    @Test
    public void test(String[] args){
        File dir = new File("D:\\Java\\jdk1.6.0_02\\include" );
        listAll(dir,0);
    }

    public static void listAll(File dir, int level){
        System.out.println(getSpace(level) + "dir:" + dir.getAbsolutePath());
        //获取指定目录下当前的所有文件夹或者文件对象
        level++;
        File[] files = dir.listFiles();

        for (int x = 0; x < files.length; x++){
            if (files[x].isDirectory()){
                listAll(files[x],level);
            }
            System.out.println(getSpace(level) + "file:" + files[x].getAbsolutePath());
        }
    }

    private static String getSpace( int level){
        StringBuilder sb = new StringBuilder();

        sb.append( "|--" );
        for (int x = 0; x < level; x++){
            sb.append( "| " );
        }

        return sb.toString();
    }
}

class FilterByHidden implements FilenameFilter {
    public boolean accept(File dir,String name){
        return dir.isHidden();
    }
}
