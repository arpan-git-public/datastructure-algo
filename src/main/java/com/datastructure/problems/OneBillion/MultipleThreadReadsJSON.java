package com.datastructure.problems.OneBillion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.AccessMode;

public class MultipleThreadReadsJSON {


    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "C:/Mywork/data/comments_500.txt";

        try(RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "r");
            FileChannel fileChannel = randomAccessFile.getChannel()){

            //allocate a ByteBuffer to hold the file's content
            long fileSize = fileChannel.size();
            ByteBuffer buffer = ByteBuffer.allocate((int)fileSize);

            fileChannel.read(buffer); //read file into bytebuffer
            buffer.flip(); //prepare buffer for read.

            String jsonString = new String(buffer.array(),StandardCharsets.UTF_8);

            System.out.println("JSON sting: " + jsonString);

            //bind the comments



        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
