package io.nio.buffer;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BufferDemo {

    public static void main(String[] args) throws Exception {

        String filePath = BufferDemo.class.getClassLoader().getResource("test/BufferDemo.txt").getFile();
        FileInputStream fileInputStream = new FileInputStream(filePath);
        FileChannel fileChannel = fileInputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocateDirect(10);
        output("init", buffer);

        fileChannel.read(buffer);
        output("read", buffer);

        buffer.flip();
        output("flip", buffer);

        while (buffer.remaining() > 0) {
            byte b = buffer.get();
            System.out.println((char)b);
        }
        output("get", buffer);


        buffer.clear();
        output("clear", buffer);
    }

    private static void output(String step, ByteBuffer buffer) {

        System.out.println("step: " + step);
        System.out.println("capacity: " + buffer.capacity());
        System.out.println("position: " + buffer.position());
        System.out.println("limit: " + buffer.limit());
        System.out.println();

    }

}
