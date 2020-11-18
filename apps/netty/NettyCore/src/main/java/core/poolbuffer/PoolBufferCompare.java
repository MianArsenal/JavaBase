package core.poolbuffer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.util.ResourceLeakDetector;

public class PoolBufferCompare {

    public static void main(String[] args) {
        ResourceLeakDetector.setLevel(ResourceLeakDetector.Level.ADVANCED);
        final byte[] CONTENT = new byte[1024];
        int loop = 1800000;
        long startTime = System.currentTimeMillis();
        ByteBuf poolBuffer;
        for (int i = 0; i < loop; i++) {
            poolBuffer = PooledByteBufAllocator.DEFAULT.directBuffer(1024);
            poolBuffer.writeBytes(CONTENT);
            poolBuffer.release();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);

        long startTime2 = System.currentTimeMillis();
        ByteBuf byteBuf;
        for (int i = 0; i < loop; i++) {
            byteBuf = Unpooled.directBuffer(1024);
            byteBuf.writeBytes(CONTENT);
            //测试时不调用，会报内存泄漏错误，但是这是为了保证每次都申请新的内存
//            byteBuf.release();
        }
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime2);
    }

}
