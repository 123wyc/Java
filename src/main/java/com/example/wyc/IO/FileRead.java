package com.example.wyc.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;

/**
 * @author wyc
 * @date 2020/8/26/14:00
 */

interface FileCopyRunner{

    void copyFile(File source, File target);
}


public class FileRead {


    public static void main(String[] args) {



        FileCopyRunner nioBufferCopy = new FileCopyRunner() {
            @Override
            public void copyFile(File source, File target) {

                FileChannel fin  = null;
                FileChannel fout  = null;

                try {

                    fin = new FileInputStream(source).getChannel();
                    fout = new FileInputStream(target).getChannel();

                    ByteBuffer buffer = ByteBuffer.allocate(1024);

                    while(fin.read(buffer)!=-1){

                        buffer.flip();

                        while (buffer.hasRemaining()){
                            fout.write(buffer);
                        }
                        buffer.clear();
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally{

                    try {
                        fin.close();
                        fout.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }


            }
        };
    }


}
