package io.aio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AioServer {

    private final int port;

    public AioServer(int port) {
        this.port = port;
        listen();
    }

    private void listen() {
        try {
            ExecutorService executorService = Executors.newCachedThreadPool();
            AsynchronousChannelGroup threadGroup = AsynchronousChannelGroup.withCachedThreadPool(executorService, 1);
            final AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open(threadGroup);
            serverSocketChannel.bind(new InetSocketAddress(port));
            System.out.println("服务已启动，监听端口：" + port);

            serverSocketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {

                final ByteBuffer buffer = ByteBuffer.allocate(1024);

                @Override
                public void completed(AsynchronousSocketChannel result, Object attachment) {
                    System.out.println("I/O 操作成功， 开始获取数据");
                    try {
                        buffer.clear();
                        //读取客户端数据
                        result.read(buffer).get();
                        System.out.println("服务端收到数据：" + new String(buffer.array()));
                        buffer.flip();
                        //发送客户端数据
                        ByteBuffer resBuffer = ByteBuffer.wrap("这是一条处理后的数据".getBytes());
                        result.write(resBuffer);
                        resBuffer.flip();
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            result.close();
                            serverSocketChannel.accept(null, this);
                        } catch (Exception e) {
                            System.out.println(e.toString());
                        }
                    }
                    System.out.println("操作完成");
                }

                @Override
                public void failed(Throwable exc, Object attachment) {
                    System.out.println("I/O 操作失败");
                }
            });
            try {
                Thread.sleep(Integer.MAX_VALUE);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    public static void main(String[] args) {
        new AioServer(8000);
    }
}
