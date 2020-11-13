package io.nio.buffer;

import java.nio.ByteBuffer;

public class BufferSlice {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);

        for (int i = 0; i < byteBuffer.capacity(); i++) {
            byteBuffer.put((byte) i);
        }

        //创建子缓冲区
        byteBuffer.position(3);
        byteBuffer.limit(7);
        ByteBuffer slice = byteBuffer.slice();

        for (int i = 0; i < slice.capacity(); i++) {
            byte b = slice.get();
            b *= 10;
            slice.put(i, b);
        }

        byteBuffer.position(0);
        byteBuffer.limit(byteBuffer.capacity());

        System.out.println("result");
        while(byteBuffer.hasRemaining()) {
            byte b = byteBuffer.get();
            System.out.println(b);
        }
    }

}
