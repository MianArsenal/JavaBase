package io.nio.buffer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class DirectBuffer {

    public static void main(String[] args) throws Exception {

        String filePath = DirectBuffer.class.getClassLoader().getResource("test/DirectBufferRead.txt").getFile();
        FileInputStream fileInputStream = new FileInputStream(filePath);
        FileChannel fileChannel = fileInputStream.getChannel();

        String outFile = DirectBuffer.class.getClassLoader().getResource("").getPath() + "/" + "test/DirectBufferWrite.txt";
        FileOutputStream fileOutputStream = new FileOutputStream(outFile);
        FileChannel outFileChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer  = ByteBuffer.allocateDirect(1024);

        while (true) {
            byteBuffer.clear();
            int r = fileChannel.read(byteBuffer);
            if(r == -1) {
                break;
            }
            byteBuffer.flip();
            outFileChannel.write(byteBuffer);
        }
    }

}
