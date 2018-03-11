package com.csx.io.encode;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Author: csx
 * @Date: 2018-03-10
 */
public class Test {
    /**
     *   在java中，字符串“abcd”与字符串“ab您好”的长度是一样，都是四个字符。
     *   但对应的字节数不同，一个汉字占两个字节。
     *   定义一个方法，按照最大的字节数来取子串。
     *   如：对于“ab你好”，如果取三个字节，那么子串就是ab与“你”字的半个。
     *   那么半个就要舍弃。如果取四个字节就是“ab你”，取五个字节还是“ab你”
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String str = "ab你好cd谢谢" ;

        int len = str.getBytes("gbk" ).length;

        byte[] bytes=str.getBytes("UTF-8");
        for(int i=0;i<bytes.length;i++){

            System.out.print(bytes[i]+" ");
        }
        for(int x = 1; x < len; x++){
            System.out.println( "截取的" + (x + 1) + "个节结果是：" + cutStringByByte(str,x+1));
        }
    }

    public static String cutStringByByte(String str,int len) throws IOException {
        byte[] buf = str.getBytes("gbk");

        int count = 0;
        for (int x = len - 1; x >= 0; x--) {
            //gbk编码的值两个字节值一般都为负，记录连续的负数个数，如果为奇数，则舍弃
            if (buf[x] < 0)
                count++;
            else
                break;
        }

        if (count % 2 == 0) {
            return new String(buf, 0, len, "gbk");
        } else {
            return new String(buf, 0, len - 1, "gbk");
        }
    }

    public static String cutStringByByteofUTF8(String str,int len) throws Exception {
        byte[] buf = str.getBytes("utf-8" );

        int count = 0;
        for(int x = len - 1; x >= 0; x--){
            if(buf[x] < 0)
                count++;
            else
                break;
        }

        if(count % 3 == 0)
            return new String(buf,0,len,"utf-8");
        else if (count % 3 == 1)
            return new String(buf,0,len-1,"utf-8");
        else
            return new String(buf,0,len-2,"utf-8");
    }
}
