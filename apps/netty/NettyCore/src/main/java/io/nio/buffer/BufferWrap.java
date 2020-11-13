package io.nio.buffer;

import java.nio.ByteBuffer;

public class BufferWrap {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);

        byte[] bytes = new byte[8];
        ByteBuffer byteBuffer1 = ByteBuffer.wrap(bytes);
    }

}
