package com.csx.io.other;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-03-10
 */
public class PipedStream {
    public static void main(String[] args) throws IOException {
        PipedInputStream input = new PipedInputStream();
        PipedOutputStream output = new PipedOutputStream();

        input.connect(output);

        new Thread(new Input(input)).start();
        new Thread(new Output(output)).start();
    }
}

class Input implements Runnable{
    private PipedInputStream in;

    Input(PipedInputStream in){
        this.in = in;
    }

    public void run(){
        try{
            byte[] buf = new byte[1024];
            int len = in.read(buf);

            String s = new String(buf,0,len);
            System.out.println( "s=" + s);
            in.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}

class Output implements Runnable{
    private PipedOutputStream out;

    Output(PipedOutputStream out){
        this.out = out;
    }

    public void run(){
        try{
            out.write( "hi,管道来了！" .getBytes());
            out.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
