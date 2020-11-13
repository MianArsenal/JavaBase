package io.nio.buffer;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MapperBuffer {

    public static final int start = 0;
    public static final int size = 1024;

    public static void main(String[] args) throws Exception{
//        String filePath = MapperBuffer.class.getClassLoader().getResource("test/MapperBuffer.txt").getFile();
        RandomAccessFile randomAccessFile = new RandomAccessFile("C:\\githome\\JavaBase\\apps\\netty\\NettyCore\\src\\main\\resources\\test\\MapperBuffer.txt", "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();

        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, start, size);

        mappedByteBuffer.put(0, (byte)98);
        mappedByteBuffer.put(1023, (byte)122);

        randomAccessFile.close();
    }

}
