package io.nio.buffer;

import java.nio.IntBuffer;

public class InputBufferDemo {

    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(8);
        for (int i = 0; i < buffer.capacity(); i++) {
            int j = 2 * (i + 1);
            buffer.put(j);
        }
        buffer.flip();
        while (buffer.remaining() > 0) {
            int j = buffer.get();
            System.out.println(j);
        }
    }

}
