package io.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;

public class AioClient {

    private final AsynchronousSocketChannel socketChannel;

    public AioClient() throws IOException {
        this.socketChannel = AsynchronousSocketChannel.open();
    }

    public void connect(String host, int port) {
        this.socketChannel.connect(new InetSocketAddress(host, port), null, new CompletionHandler<Void, Object>() {
            @Override
            public void completed(Void result, Object attachment) {
                try {
                    socketChannel.write(ByteBuffer.wrap("这是一条测试数据".getBytes())).get();
                    System.out.println("已发送至服务器");
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                exc.printStackTrace();
            }
        });
        final ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        this.socketChannel.read(byteBuffer, null, new CompletionHandler<Integer, Object>() {
            @Override
            public void completed(Integer result, Object attachment) {
                System.out.println("I/O 操作完成" + result);
                System.out.println("获取到的反馈结果：" + new String(byteBuffer.array()));
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                exc.printStackTrace();
            }
        });
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws IOException {
        new AioClient().connect("localhost", 8000);
    }

}
