package io.nio.buffer;

import java.nio.ByteBuffer;

public class ReadOnlyBuffer {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);

        for (int i = 0; i < byteBuffer.capacity(); i++) {
            byteBuffer.put((byte) i);
        }

        ByteBuffer readOnly = byteBuffer.asReadOnlyBuffer();

        byteBuffer.flip();
        for (int i = 0; i < byteBuffer.capacity(); i++) {
            byte b = byteBuffer.get();
            b *= 10;
            byteBuffer.put(i, b);
        }

        readOnly.flip();
        while (readOnly.hasRemaining()) {
            byte b = readOnly.get();
            System.out.println(b);
        }
    }

}
